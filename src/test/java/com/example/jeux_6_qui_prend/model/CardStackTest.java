package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class CardStackTest {
    @Mock
    List<Card> cards;
    @InjectMocks
    CardStack cardStack;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCardCount() {
        int result = cardStack.getCardCount();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testAddMayTakeIfBelowOr6th() {
        List<Card> result = cardStack.addMayTakeIfBelowOr6th(new Card(0, 0));
        Assertions.assertEquals(List.of(new Card(0, 0)), result);
    }

    @Test
    void testResetWithTopCard() {
        cardStack.resetWithTopCard(new Card(0, 0));
    }

    @Test
    void testGetCard() {
        Card result = cardStack.getCard(0);
        Assertions.assertEquals(new Card(0, 0), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme