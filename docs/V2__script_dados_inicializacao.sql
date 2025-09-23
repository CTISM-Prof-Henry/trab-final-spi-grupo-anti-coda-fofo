--admin
INSERT INTO admin(email, senha)
	VALUES('admin@admin.com', 'admin1234');

--salas
INSERT INTO sala (nome, predio, capacidade, tipo) VALUES
('101', 'A', 40, 'AULA'),
('102', 'A', 35, 'LABORATÓRIO'),
('103', 'A', 80, 'AUDITÓRIO'),
('201', 'B', 45, 'AULA'),
('202', 'B', 50, 'OFICINA'),
('301', 'C', 30, 'MULTIUSO'),
('302', 'C', 25, 'LABORATÓRIO'),
('401', 'D', 100, 'AUDITÓRIO'),
('402', 'D', 42, 'AULA'),
('501', 'E', 28, 'MULTIUSO'),
('601', 'F', 60, 'OFICINA'),
('701', 'G', 55, 'AULA'),
('702', 'G', 38, 'LABORATÓRIO'),
('800', 'OUTRO', 120, 'AUDITÓRIO');

--professores
INSERT INTO professor (email, senha, nome, matricula) VALUES
('Daniel@poli.ufsm.com', 'senha123', 'Daniel', '123456789'),
('Leandro@poli.ufsm.com', 'senha456', 'Leandro', '987654321'),
('Rafael@poli.ufsm.com', 'senha789', 'Rafael', '112233445'),
('Marcos@poli.ufsm.com', 'senha101', 'Marcos', '556677889'),
('Alencar@poli.ufsm.com', 'senha202', 'Alencar', '998877665');

--eventos para cada professores
-- Inserção de eventos
INSERT INTO evento (nome, id_professor, tipo) VALUES
('Seminário sobre Inteligência Artificial', 1, 'SEMINÁRIO'),
('Reunião de Coordenação', 2, 'REUNIÃO'),
('Projeto de Pesquisa sobre Sustentabilidade', 3, 'PROJETO'),
('Disciplina de Cálculo I', 4, 'DISCIPLINA'),
('Palestra sobre Desenvolvimento de Software', 5, 'PALESTRA'),
('Seminário de Engenharia de Software', 1, 'SEMINÁRIO'),
('Reunião de Planejamento de Eventos', 2, 'REUNIÃO'),
('Projeto de Inovação Tecnológica', 3, 'PROJETO'),
('Disciplina de Física II', 4, 'DISCIPLINA'),
('Palestra sobre Inteligência Emocional', 5, 'PALESTRA'),
('Seminário sobre Blockchain', 1, 'SEMINÁRIO'),
('Reunião de Avaliação de Cursos', 2, 'REUNIÃO'),
('Projeto de Aplicações Móveis', 3, 'PROJETO'),
('Disciplina de Algoritmos e Estruturas de Dados', 2, 'DISCIPLINA'),
('Palestra sobre Transformação Digital', 5, 'PALESTRA'),
('Seminário de Pesquisa em Computação', 1, 'SEMINÁRIO'),
('Reunião sobre Novos Currículos', 2, 'REUNIÃO'),
('Projeto de Engenharia de Dados', 3, 'PROJETO');

