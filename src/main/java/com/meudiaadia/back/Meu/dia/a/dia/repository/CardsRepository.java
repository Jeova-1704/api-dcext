package com.meudiaadia.back.Meu.dia.a.dia.repository;

import com.meudiaadia.back.Meu.dia.a.dia.domain.CardsComunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardsRepository extends JpaRepository<CardsComunication, UUID> {

    List<CardsComunication> findAllByUserId(UUID userId);
}

