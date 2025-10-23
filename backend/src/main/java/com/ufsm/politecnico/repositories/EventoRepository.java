package com.ufsm.politecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.enums.TipoEvento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
    //listar eventos de um professor específico

    //obter evento de um id
    public Optional<Evento> findById(Long id);

   @Query(
    "SELECT e FROM Evento e " +
    "JOIN e.usuario u " +
    "WHERE (:tipo IS NULL OR e.tipo = :tipo) " +
    "AND (:nome IS NULL OR u.nome = :nome)"
   )
   List<Evento> findByTipoAndNome(
    @Param("tipo") TipoEvento tipo,
    @Param("nome") String nome
   );
}
