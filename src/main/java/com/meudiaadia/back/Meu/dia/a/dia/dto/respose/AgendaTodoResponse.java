package com.meudiaadia.back.Meu.dia.a.dia.dto.respose;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AgendaTodoResponse(
        String agenda_id,
        String user_id,
        @JsonProperty("dia_da_semana")
        String diaDaSemana,
        String dia,
        String mes,
        String titulo,
        @JsonProperty("hora_inicial")
        @JsonFormat(pattern = "HH:mm")
        String horaInicial,
        @JsonProperty("hora_final")
        @JsonFormat(pattern = "HH:mm")
        String horaFinal,
        List<TodoResponse> toDos

) {
}
