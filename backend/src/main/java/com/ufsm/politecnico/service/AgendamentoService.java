package com.ufsm.politecnico.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.model.Agendamento;
import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.Sala;
import com.ufsm.politecnico.repositories.AgendamentoRepository;
import com.ufsm.politecnico.repositories.EventoRepository;
import com.ufsm.politecnico.repositories.SalaRepository;

import jakarta.transaction.Transactional;

@Service
public class AgendamentoService {
    
    private AgendamentoRepository agendamentoRepository;
    private EventoRepository eventoRepository;
    private SalaRepository salaRepository;

    public AgendamentoService(
            AgendamentoRepository agendamentoRepository,
            EventoRepository eventoRepository,
            SalaRepository salaRepository
    ){
        this.agendamentoRepository = agendamentoRepository;
        this.eventoRepository = eventoRepository;
        this.salaRepository = salaRepository;
    }

    public List<AgendamentoDTO> buscarAgendamentoDTOs(){
        return agendamentoRepository.buscarTodosAgendamentos();
    }

    public List<AgendamentoDTO> buscarAgendamentosFuturos(){
        return agendamentoRepository.buscarAgendamentosFuturos(LocalDateTime.now());
    }

    public List<AgendamentoDTO> buscarAgendamentosPassados(){
        return agendamentoRepository.buscarAgendamentosPassados(LocalDateTime.now());
    }

    public List<AgendamentoDTO> buscarAgendamentosPeriodo(
            LocalDateTime inicio, LocalDateTime fim){
        //logica para validar data
        return agendamentoRepository.buscarAgendamentosPorPeriodo(inicio, fim);
    }

    //criar um novo agendamento, ocorrendo dentro de uma transação
    @Transactional
    public AgendamentoDTO criarAgendamento(
        Long salaId, Long eventoId,
        LocalDateTime inicio, LocalDateTime fim)
    {
        long conflitos = agendamentoRepository.obterConflitosAgendamento(salaId, inicio, fim);
        if (conflitos > 0){
            throw new IllegalArgumentException("já existe agendamento neste horário");
        }

        Sala sala = salaRepository.findById(salaId)
        .orElseThrow();

        Evento evento = eventoRepository.findById(eventoId)
        .orElseThrow();

        Agendamento agendamento = new Agendamento(null, inicio, fim, sala, evento);
        agendamentoRepository.save(agendamento);

        return new AgendamentoDTO(
           null,
           inicio,
           fim,
           sala.getNome(),
           evento.getNome(),
           evento.getProfessor().getNome(),
           sala.getTipo(),
           sala.getPredio()
        );
    }

    //deletar um agendamento observando a seguinte regra
    //ninguem pode deletar um agendamento que já terminou
    public void deletarAgendamento(Long id){
        AgendamentoDTO a = this.agendamentoRepository.buscarId(id);
        if(a==null) throw new NoSuchElementException();

        if(a.getDataHoraFim().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("nao se pode deletar um agendamento que já acabou");
        } 
        
        this.agendamentoRepository.deleteById(id);
    }
}
