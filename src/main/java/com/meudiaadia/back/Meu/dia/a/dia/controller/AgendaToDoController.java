package com.meudiaadia.back.Meu.dia.a.dia.controller;

import com.meudiaadia.back.Meu.dia.a.dia.dto.request.AgendaTodoRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.AgendaTodoResponse;
import com.meudiaadia.back.Meu.dia.a.dia.services.AgendaToDoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/agenda-to-do")
@RequiredArgsConstructor
public class AgendaToDoController {

    private final AgendaToDoServices agendaToDoServices;

    @GetMapping("/{userId}")
    public ResponseEntity<List<AgendaTodoResponse>> findAllAgendaToDoByUser(@PathVariable UUID userId) {
        List<AgendaTodoResponse> agendaTodoResponses = agendaToDoServices.findAllAgendaToDoByUser(userId);
        return ResponseEntity.ok().body(agendaTodoResponses);
    }

    @PostMapping
    public ResponseEntity<AgendaTodoResponse> createAgendaToDo(@RequestBody AgendaTodoRequest agendaTodoRequest) {
        return ResponseEntity.ok().body(agendaToDoServices.createAgendaToDo(agendaTodoRequest));
    }

    @DeleteMapping("/{agendaId}")
    public void deleteAgendaToDoById(@PathVariable UUID agendaId) {
        agendaToDoServices.deleteAgendaToDoById(agendaId);
    }
}
