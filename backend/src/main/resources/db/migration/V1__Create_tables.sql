CREATE TABLE IF NOT EXISTS usuario(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(15),
    permissao VARCHAR(20) CHECK(permissao IN(
        'ROLE_ADM', 'ROLE_PROFESSOR'
    ))
);

CREATE TABLE IF NOT EXISTS evento(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    id_usuario BIGINT NOT NULL REFERENCES 
		usuario(id) ON DELETE CASCADE,
    tipo VARCHAR(30) NOT NULL CHECK (tipo IN(
        'DISCIPLINA', 'PALESTRA', 'SEMINÁRIO', 'REUNIÃO', 'PROJETO'
    ))
);

CREATE TABLE IF NOT EXISTS sala(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(5) NOT NULL,
    predio VARCHAR(8) NOT NULL CHECK (predio IN(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'OUTRO'
    )),
    capacidade int NOT NULL,
    tipo VARCHAR(30) NOT NULL CHECK (tipo IN(
        'LABORATÓRIO', 'AULA', 'AUDITÓRIO', 'OFICINA', 'MULTIUSO'
    ))
);

--tabela de agendamento possui uma restrição check para validar a hora
-- timestam no formato 'YYYY-MM-DD HH:MI:SS'
CREATE TABLE IF NOT EXISTS agendamento(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_sala BIGINT NOT NULL REFERENCES sala(id) ON DELETE CASCADE,
    id_evento BIGINT NOT NULL REFERENCES evento(id) ON DELETE CASCADE,
    data_hora_inicio TIMESTAMP,
    data_hora_fim TIMESTAMP,
    CONSTRAINT check_horario CHECK (data_hora_inicio < data_hora_fim),
    CONSTRAINT unique_agenda UNIQUE(id_sala, data_hora_inicio, data_hora_fim)
);

-- Criar um índice GIST para otimizar consultas de intervalo de tempo
-- O GIST agora usa a função tsrange, compatível com colunas TIMESTAMP
CREATE INDEX idx_periodo ON agendamento USING gist (tsrange(data_hora_inicio, data_hora_fim));

-- Criar um índice para facilitar busca por matricula
CREATE INDEX idx_matricula ON usuario(matricula);
