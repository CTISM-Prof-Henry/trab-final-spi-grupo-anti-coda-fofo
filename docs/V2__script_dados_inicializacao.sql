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
