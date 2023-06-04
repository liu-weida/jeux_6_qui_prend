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

class CharacterTest {
    @Mock
    CardSet hand;
    @Mock
    ArrayList<Card> tbCards;
    @InjectMocks
    Character character;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddToScore() {
        character.addToScore(0);
    }

    @Test
    void testRemoveCard() {
        character.removeCard(new Card(0, 0));
    }

    @Test
    void testGetCanChooseCard() {
        Boolean result = character.getCanChooseCard();
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testSetChooseCard() {
        character.setChooseCard(Boolean.TRUE);
    }

    @Test
    void testSetCanPLayCard() {
        character.setCanPLayCard(Boolean.TRUE);
    }

    @Test
    void testAddPenality() {
        character.addPenality(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme