package com.meudiaadia.back.Meu.dia.a.dia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "cards_communication")
@Entity(name = "cards_communication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardsComunication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false)
    private String icon;

    public CardsComunication(User user, String title, String description, String icon) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    public CardsComunication(String title, String description, String icon) {
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

}
