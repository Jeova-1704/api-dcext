package com.meudiaadia.back.Meu.dia.a.dia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "agenda")
@Entity(name = "agenda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false, length = 50)
    private String diaDaSemana;
    @Column(nullable = false)
    private Integer dia;
    @Column(nullable = false, length = 50)
    private String mes;
    @Column(nullable = false, length = 50)
    private String titulo;
    @Column(nullable = false, length = 50)
    private String horaInicial;
    @Column(nullable = false, length = 50)
    private String horaFinal;
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToDo> toDos;

    public Agenda(String diaDaSemana, Integer dia, String mes, String titulo, String horaInicial, String horaFinal) {
        this.diaDaSemana = diaDaSemana;
        this.dia = dia;
        this.mes = mes;
        this.titulo = titulo;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public Agenda(String diaDaSemana, Integer dia, String mes, String titulo, String horaInicial, String horaFinal, List<ToDo> toDos) {
        this.diaDaSemana = diaDaSemana;
        this.dia = dia;
        this.mes = mes;
        this.titulo = titulo;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.toDos = toDos;
    }
}
