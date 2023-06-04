package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class CardsTest {
    @Mock
    List<Card> cards;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCardOf() {
        Card result = Cards.cardOf(0);
        Assertions.assertEquals(new Card(0, 0), result);
    }

    @Test
    void testCardPenalty() {
        int result = Cards.cardPenalty(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDistributeRandomCards() {
        List<CardSet> result = Cards.distributeRandomCards(0, null);
        Assertions.assertEquals(List.of(new CardSet(List.of(new Card(0, 0)))), result);
    }

    @Test
    void testDistributeRandomCards2() {
        List<CardSet> result = Cards.distributeRandomCards(0, null, 0);
        Assertions.assertEquals(List.of(new CardSet(List.of(new Card(0, 0)))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme