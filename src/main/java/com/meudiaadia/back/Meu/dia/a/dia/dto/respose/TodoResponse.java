package com.meudiaadia.back.Meu.dia.a.dia.dto.respose;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TodoResponse(
        @JsonProperty("to_do_id")
        String toDoId,
        @JsonProperty("agenda_id")
        String agendaId,
        String description
) {
}
