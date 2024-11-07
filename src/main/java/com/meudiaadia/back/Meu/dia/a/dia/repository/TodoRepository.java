package com.meudiaadia.back.Meu.dia.a.dia.repository;

import com.meudiaadia.back.Meu.dia.a.dia.domain.Agenda;
import com.meudiaadia.back.Meu.dia.a.dia.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, UUID> {
    List<ToDo> findAllByAgendaId(UUID agendaId);
    void deleteAllByAgendaId(UUID agendaId);
}

