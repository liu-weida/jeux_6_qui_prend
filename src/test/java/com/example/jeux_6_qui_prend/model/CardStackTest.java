package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CardStackTest {
    @Mock
    java.util.List<com.example.jeux_6_qui_prend.model.Card> cards;
    @InjectMocks
    com.example.jeux_6_qui_prend.model.CardStack cardStack;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCardCount(){
        int result = cardStack.getCardCount();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testAddMayTakeIfBelowOr6th(){
        java.util.List<com.example.jeux_6_qui_prend.model.Card> result = cardStack.addMayTakeIfBelowOr6th(new com.example.jeux_6_qui_prend.model.Card(0, 0));
        Assertions.assertEquals(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)), result);
    }

    @Test
    void testResetWithTopCard(){
        cardStack.resetWithTopCard(new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }

    @Test
    void testGetCard(){
        com.example.jeux_6_qui_prend.model.Card result = cardStack.getCard(0);
        Assertions.assertEquals(new com.example.jeux_6_qui_prend.model.Card(0, 0), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme