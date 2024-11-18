package com.meudiaadia.back.Meu.dia.a.dia.services;

import com.meudiaadia.back.Meu.dia.a.dia.domain.Agenda;
import com.meudiaadia.back.Meu.dia.a.dia.domain.ToDo;
import com.meudiaadia.back.Meu.dia.a.dia.domain.User;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.AgendaTodoRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.TodoRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.AgendaTodoResponse;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.TodoResponse;
import com.meudiaadia.back.Meu.dia.a.dia.repository.AgendaRepository;
import com.meudiaadia.back.Meu.dia.a.dia.repository.TodoRepository;
import com.meudiaadia.back.Meu.dia.a.dia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendaToDoServices {

    private final AgendaRepository agendaRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public AgendaTodoResponse createAgendaToDo(AgendaTodoRequest agendaTodoRequest) {
        Agenda agenda = agendaRequestToDomain(agendaTodoRequest);
        agenda = agendaRepository.save(agenda);
        List<ToDo> todo = todoRequestToDomain(agendaTodoRequest);
        for (ToDo toDo : todo) {
            toDo.setAgenda(agenda);
        }
        todo = todoRepository.saveAll(todo);
        return agendaTodoResponseFromDomain(agenda, todo);
    }

    public List<AgendaTodoResponse> findAllAgendaToDoByUser(UUID userId) {
        List<Agenda> agendas = agendaRepository.findAllByUserId(userId);
        List<AgendaTodoResponse> agendaTodoResponses = new ArrayList<>();
        for (Agenda agenda : agendas) {
            List<ToDo> todo = todoRepository.findAllByAgendaId(agenda.getId());
            agendaTodoResponses.add(agendaTodoResponseFromDomain(agenda, todo));
        }
        return agendaTodoResponses;
    }

    public void deleteAgendaToDoById(UUID agendaId) {
        todoRepository.deleteAllByAgendaId(agendaId);
        agendaRepository.deleteById(agendaId);
    }





    private AgendaTodoResponse agendaTodoResponseFromDomain(Agenda agenda, List<ToDo> todo) {
        List<TodoResponse> todoResponses = new ArrayList<>();
        for (ToDo toDo : todo) {
            TodoResponse todoResponse = new TodoResponse(String.valueOf(toDo.getId()), String.valueOf(agenda.getId()), toDo.getDescricao());
            todoResponses.add(todoResponse);
        }
        return new AgendaTodoResponse(
                String.valueOf(agenda.getId()),
                String.valueOf(agenda.getUser().getId()),
                String.valueOf(agenda.getDiaDaSemana()),
                String.valueOf(agenda.getDia()),
                agenda.getMes(),
                agenda.getTitulo(),
                agenda.getHoraInicial(),
                agenda.getHoraFinal(),
                todoResponses);
    }

    private List<ToDo> todoRequestToDomain(AgendaTodoRequest agendaTodoRequest) {
        List<ToDo> toDos = new ArrayList<>();
        for (TodoRequest descricao : agendaTodoRequest.toDos()) {
            ToDo toDo = new ToDo();
            toDo.setDescricao(descricao.descricao());
            toDos.add(toDo);
        }
        return toDos;
    }

    private Agenda agendaRequestToDomain(AgendaTodoRequest agendaTodoRequest) {
        Agenda agenda = new Agenda();
        User user = userRepository.findById(UUID.fromString(agendaTodoRequest.user_id())).orElseThrow();
        agenda.setUser(user);
        agenda.setDiaDaSemana(agendaTodoRequest.diaDaSemana());
        agenda.setDia(agendaTodoRequest.dia());
        agenda.setMes(agendaTodoRequest.mes());
        agenda.setTitulo(agendaTodoRequest.titulo());
        agenda.setHoraInicial(agendaTodoRequest.horaInicial());
        agenda.setHoraFinal(agendaTodoRequest.horaFinal());
        return agenda;
    }

    @Transactional
    public AgendaTodoResponse findAgendaToDoById(UUID agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow();
        List<ToDo> todo = todoRepository.findAllByAgendaId(agendaId);
        return agendaTodoResponseFromDomain(agenda, todo);
    }
}
