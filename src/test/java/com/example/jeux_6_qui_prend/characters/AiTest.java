package com.example.jeux_6_qui_prend.characters;

import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardSet;
import com.example.jeux_6_qui_prend.model.CardStack;
import com.example.jeux_6_qui_prend.ui.GameView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class AiTest {
    @Mock
    CardSet hand;
    @Mock
    ArrayList<Card> tbCards;
    @InjectMocks
    Ai ai;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSelectCard() {
        when(hand.remains()).thenReturn(List.of(new Card(0, 0)));

        Card result = ai.selectCard(new ArrayList<>(List.of(new CardStack(new Card(0, 0)))));
        Assertions.assertEquals(new Card(0, 0), result);
    }

    @Test
    void testPlayCard() {
        ai.playCard(new ArrayList<>(List.of(new CardStack(new Card(0, 0)))), new Card(0, 0), new GameView());
    }

    @Test
    void testAddToScore() {
        ai.addToScore(0);
    }

    @Test
    void testRemoveCard() {
        ai.removeCard(new Card(0, 0));
    }

    @Test
    void testGetCanChooseCard() {
        Boolean result = ai.getCanChooseCard();
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testSetChooseCard() {
        ai.setChooseCard(Boolean.TRUE);
    }

    @Test
    void testSetCanPLayCard() {
        ai.setCanPLayCard(Boolean.TRUE);
    }

    @Test
    void testAddPenality() {
        ai.addPenality(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme