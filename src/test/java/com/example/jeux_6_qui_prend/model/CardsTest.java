package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CardsTest {
    @Mock
    java.util.List<com.example.jeux_6_qui_prend.model.Card> cards;
    @InjectMocks
    com.example.jeux_6_qui_prend.model.Cards cards;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCardOf(){
        com.example.jeux_6_qui_prend.model.Card result = Cards.cardOf(0);
        Assertions.assertEquals(new com.example.jeux_6_qui_prend.model.Card(0, 0), result);
    }

    @Test
    void testCardPenalty(){
        int result = Cards.cardPenalty(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDistributeRandomCards(){
        java.util.List<com.example.jeux_6_qui_prend.model.CardSet> result = Cards.distributeRandomCards(0, null);
        Assertions.assertEquals(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)))), result);
    }

    @Test
    void testDistributeRandomCards2(){
        java.util.List<com.example.jeux_6_qui_prend.model.CardSet> result = Cards.distributeRandomCards(0, null, 0);
        Assertions.assertEquals(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme