-- Usuário administrador senha 1234 com bcript(12)
INSERT INTO usuario (email, senha, nome, matricula, permissao)
VALUES ('admin@ufsm.br', '$2a$12$ZgMKDKQENvSebmczOTS6j.5OflWu31WKG0qTOpySGlhsVLOV7QRn6', 'Administrador do Sistema', NULL, 'ROLE_ADM');

-- Usuário professor senha 1234 com bcripy(12)
INSERT INTO usuario (email, senha, nome, matricula, permissao)
VALUES ('professor@ufsm.br', '$2a$12$1Qc9LQ8dPKSx4elrwKSo7O51n8jIu6KdzUjDxh/o1iFV1k0FsR9Gi', 'Professor João da Silva', '20251234', 'ROLE_PROFESSOR');

INSERT INTO sala (nome, predio, capacidade, tipo)
VALUES ('101', 'B', 40, 'AULA');

INSERT INTO evento (nome, id_usuario, tipo)
VALUES ('Aula de Programação Web', 2, 'DISCIPLINA');

INSERT INTO agendamento (id_sala, id_evento, data_hora_inicio, data_hora_fim)
VALUES (1, 1, '2025-10-25 08:00:00', '2025-10-25 10:00:00');
