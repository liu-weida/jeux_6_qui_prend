package com.example.jeux_6_qui_prend.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class AiTest {
    @Mock
    com.example.jeux_6_qui_prend.model.CardSet hand;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> tbCards;
    @InjectMocks
    com.example.jeux_6_qui_prend.characters.Ai ai;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSelectCard(){
        when(hand.remains()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));

        com.example.jeux_6_qui_prend.model.Card result = ai.selectCard(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardStack(new com.example.jeux_6_qui_prend.model.Card(0, 0)))));
        Assertions.assertEquals(new com.example.jeux_6_qui_prend.model.Card(0, 0), result);
    }

    @Test
    void testPlayCard(){
        ai.playCard(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardStack(new com.example.jeux_6_qui_prend.model.Card(0, 0)))), new com.example.jeux_6_qui_prend.model.Card(0, 0), new com.example.jeux_6_qui_prend.ui.GameView());
    }

    @Test
    void testAddToScore(){
        ai.addToScore(0);
    }

    @Test
    void testRemoveCard(){
        ai.removeCard(new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }

    @Test
    void testGetCanChooseCard(){
        java.lang.Boolean result = ai.getCanChooseCard();
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testSetChooseCard(){
        ai.setChooseCard(Boolean.TRUE);
    }

    @Test
    void testSetCanPLayCard(){
        ai.setCanPLayCard(Boolean.TRUE);
    }

    @Test
    void testAddPenality(){
        ai.addPenality(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme