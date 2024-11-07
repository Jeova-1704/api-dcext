package com.meudiaadia.back.Meu.dia.a.dia.controller;

import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CardsRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CardsRequestId;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.UserCardsRequestId;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.CardsResponse;
import com.meudiaadia.back.Meu.dia.a.dia.services.CardsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardsController {

    private final CardsServices cardsServices;

    @PostMapping("/create")
    public ResponseEntity<CardsResponse> create(@RequestBody CardsRequest cardsRequest) {
        return ResponseEntity.ok(cardsServices.create(cardsRequest));
    }

    @PostMapping("/get-all")
    public ResponseEntity<List<CardsResponse>> getALlCardsByUser(@RequestBody UserCardsRequestId cardsRequest) {
        List<CardsResponse> cardsComunications = cardsServices.findAllCardsByUser(UUID.fromString(cardsRequest.user_id()));
        return ResponseEntity.ok().body(cardsComunications);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CardsRequestId cardsRequest) {
        cardsServices.delete(UUID.fromString(cardsRequest.cardId()));
        return ResponseEntity.noContent().build();
    }

}
