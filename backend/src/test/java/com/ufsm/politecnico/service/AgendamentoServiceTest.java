package com.ufsm.politecnico.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ufsm.politecnico.dto.AgendamentoDTO;
import com.ufsm.politecnico.model.Agendamento;
import com.ufsm.politecnico.model.Evento;
import com.ufsm.politecnico.model.Professor;
import com.ufsm.politecnico.model.Sala;
import com.ufsm.politecnico.repositories.AgendamentoRepository;
import com.ufsm.politecnico.repositories.EventoRepository;
import com.ufsm.politecnico.repositories.SalaRepository;


@ExtendWith(MockitoExtension.class)
class AgendamentoServiceTest {

    //criar mocks de nossos repositories para simular o comportamento
    @Mock
    private AgendamentoRepository agendamentoRepository;

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private SalaRepository salaRepository;

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Test
    void criarAgendamento_deveSalvarEretornarDTO() {
        // Arrange: preparar inputs
        Long salaId = 1L;
        Long eventoId = 2L;
        //da data de agora 1 dia depois e dura 2 horas
        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fim = inicio.plusHours(2);

        // criar objetos que os repositórios retornarão
        Sala sala = new Sala();
        sala.setId(salaId);
        sala.setNome("Sala A");
        // tipo/predio podem ficar nulos ou setados se desejar

        Professor professor = new Professor();
        professor.setNome("Prof X");

        Evento evento = new Evento();
        evento.setId(eventoId);
        evento.setNome("Evento Y");
        evento.setProfessor(professor);

        // mocks: nenhum conflito, sala e evento existem
        when(agendamentoRepository.obterConflitosAgendamento(salaId, inicio, fim)).thenReturn(0L);
        when(salaRepository.findById(salaId)).thenReturn(Optional.of(sala));
        when(eventoRepository.findById(eventoId)).thenReturn(Optional.of(evento));

        // quando salvar, simulamos que o repo atribui um id
        when(agendamentoRepository.save(any(Agendamento.class))).thenAnswer(invocation -> {
            Agendamento arg = invocation.getArgument(0);
            arg.setId(123L);
            return arg;
        });

        // Act: executar o método do service
        AgendamentoDTO dto = agendamentoService.criarAgendamento(salaId, eventoId, inicio, fim);

        // Assert: verificar o DTO e que o save foi chamado com os valores esperados
        assertNotNull(dto, "DTO não deve ser nulo");
        assertEquals(inicio, dto.getDataHoraInicio());
        assertEquals(fim, dto.getDataHoraFim());
        assertEquals("Sala A", dto.getNomeSala());
        assertEquals("Evento Y", dto.getNomeEvento());
        assertEquals("Prof X", dto.getNomeProfessor());

        // capturar o argumento usado em save e verificar campos da entidade
        ArgumentCaptor<Agendamento> captor = ArgumentCaptor.forClass(Agendamento.class);
        verify(agendamentoRepository, times(1)).save(captor.capture());
        Agendamento salvo = captor.getValue();
        assertEquals(inicio, salvo.getDataHoraInicio());
        assertEquals(fim, salvo.getDataHoraFim());
        assertEquals(sala, salvo.getSala());
        assertEquals(evento, salvo.getEvento());
    }
}
