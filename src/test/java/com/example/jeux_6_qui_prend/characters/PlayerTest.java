package com.example.jeux_6_qui_prend.characters;

import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class PlayerTest {
    @Mock
    CardSet hand;
    @Mock
    ArrayList<Card> tbCards;
    @InjectMocks
    Player player;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddToScore() {
        player.addToScore(0);
    }

    @Test
    void testRemoveCard() {
        player.removeCard(new Card(0, 0));
    }

    @Test
    void testGetCanChooseCard() {
        Boolean result = player.getCanChooseCard();
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testSetChooseCard() {
        player.setChooseCard(Boolean.TRUE);
    }

    @Test
    void testSetCanPLayCard() {
        player.setCanPLayCard(Boolean.TRUE);
    }

    @Test
    void testAddPenality() {
        player.addPenality(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme