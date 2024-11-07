package com.meudiaadia.back.Meu.dia.a.dia.services;

import com.meudiaadia.back.Meu.dia.a.dia.domain.CardsComunication;
import com.meudiaadia.back.Meu.dia.a.dia.domain.User;
import com.meudiaadia.back.Meu.dia.a.dia.dto.request.CardsRequest;
import com.meudiaadia.back.Meu.dia.a.dia.dto.respose.CardsResponse;
import com.meudiaadia.back.Meu.dia.a.dia.repository.CardsRepository;
import com.meudiaadia.back.Meu.dia.a.dia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardsServices {

    private final UserRepository userRepository;
    private final CardsRepository cardsRepository;

    public CardsResponse create(CardsRequest cardsRequest) {
        User user = userRepository.findById(UUID.fromString(cardsRequest.user_id()))
                .orElseThrow(() -> new RuntimeException("User not found"));
        CardsComunication cardsComunication = new CardsComunication(user, cardsRequest.title(), cardsRequest.description(), cardsRequest.icon());
        cardsComunication = cardsRepository.save(cardsComunication);
        return domainToResponse(cardsComunication);
    }

    public List<CardsResponse> findAllCardsByUser(UUID userId) {
        List<CardsComunication> cardsComunications = cardsRepository.findAllByUserId(userId);
        return cardsComunications.stream().map(this::domainToResponse).toList();
    }

    public void delete(UUID id) {
        cardsRepository.deleteById(id);
    }

    private CardsResponse domainToResponse(CardsComunication cardsComunication) {
        return new CardsResponse(cardsComunication.getId().toString(), cardsComunication.getTitle(), cardsComunication.getDescription(), cardsComunication.getIcon());
    }
}