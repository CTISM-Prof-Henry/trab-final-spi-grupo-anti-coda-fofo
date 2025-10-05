package com.ufsm.politecnico.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // JPQL base para projeção de DTO, reutilizado em todos os métodos de busca
    String QUERY_STRING_DTO = "SELECT new com.ufsm.politecnico.dto.AgendamentoDTO("
        + "a.id,"
        + "a.dataHoraInicio,"
        + "a.dataHoraFim,"
        + "a.sala.nome,"
        + "a.evento.nome,"
        + "a.evento.professor.nome,"
        + "a.sala.tipo,"
        + "a.sala.predio"
        + ") "
        + "From Agendamento a "
        + "JOIN a.sala s "
        + "JOIN a.evento e "
        + "JOIN a.evento.professor ";

    //busca todos os agendamentos convertendo já para um DTO
    @Query(QUERY_STRING_DTO)
    List<AgendamentoDTO> buscarTodosAgendamentos();

     // 2. Agendamentos em Andamento ou Futuros (A partir da data/hora atual)
    // Usamos 'a.dataHoraFim' para garantir que agendamentos que já começaram, mas não terminaram, sejam incluídos
    @Query(QUERY_STRING_DTO + "WHERE a.dataHoraFim >= :dataHoraAtual")
    List<AgendamentoDTO> buscarAgendamentosFuturos(@Param("dataHoraAtual") LocalDateTime dataHoraAtual);

    // 3. Agendamentos Passados (Que terminaram antes da data/hora atual)
    @Query(QUERY_STRING_DTO + "WHERE a.dataHoraFim < :dataHoraAtual")
    List<AgendamentoDTO> buscarAgendamentosPassados(@Param("dataHoraAtual") LocalDateTime dataHoraAtual);
    
    // 4. Agendamentos em um Período Específico
    // Filtra agendamentos onde o período de agendamento (início a fim) se sobrepõe ao período desejado
    @Query(QUERY_STRING_DTO + 
           "WHERE a.dataHoraInicio >= :dataInicioPeriodo AND a.dataHoraFim <= :dataFimPeriodo " +
           "ORDER BY a.dataHoraInicio")
    List<AgendamentoDTO> buscarAgendamentosPorPeriodo(
        LocalDateTime dataInicioPeriodo,
        LocalDateTime dataFimPeriodo
    );
}
