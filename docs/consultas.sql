--não foram testados


--salas livres | Melhorar dps
SELECT s.*
FROM sala s
LEFT JOIN agendamento a ON a.id_sala = s.id
WHERE a.id_sala IS NULL;


--filtros relacionados a salas

--filtro prédio
SELECT * 
FROM sala s 
WHERE
s.predio = 'Bloco1'

--filtro tipo de sala
SELECT * 
FROM sala s 
WHERE	
s.tipo = 'aula'



--Filtro por tipo de evento
SELECT 
    a.id AS agendamento_id,
    a.data_hora_inicio,
    a.data_hora_fim,
    e.nome AS evento_nome,
    e.tipo AS evento_tipo,
    s.nome AS sala_nome,
    s.predio,
    s.capacidade,
    s.tipo AS sala_tipo
FROM agendamento a
JOIN evento e ON a.id_evento = e.id
JOIN sala s ON a.id_sala = s.id
WHERE e.tipo = 'seminário';

--filtros por data

--salas livres - entre datas
SELECT *
FROM sala s
WHERE NOT EXISTS (
    SELECT 1
    FROM agendamento a
    WHERE a.id_sala = s.id
      AND a.data_hora_inicio < ?
      AND a.data_hora_fim > ?
);


--Salas ocupadas
SELECT 
    a.id AS agendamento_id,
    a.data_hora_inicio,
    a.data_hora_fim,
    e.nome AS evento_nome,
    e.tipo AS evento_tipo,
    s.nome AS sala_nome,
    s.predio,
    s.capacidade,
    s.tipo AS sala_tipo
FROM agendamento a
JOIN evento e ON a.id_evento = e.id
JOIN sala s ON a.id_sala = s.id
WHERE a.data_hora_inicio < ?
  AND a.data_hora_fim > ?;




