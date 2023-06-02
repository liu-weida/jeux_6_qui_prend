package com.example.jeux_6_qui_prend.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CharacterTest {
    @Mock
    com.example.jeux_6_qui_prend.model.CardSet hand;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> tbCards;
    @InjectMocks
    com.example.jeux_6_qui_prend.characters.Character character;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddToScore(){
        character.addToScore(0);
    }

    @Test
    void testRemoveCard(){
        character.removeCard(new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }

    @Test
    void testGetCanChooseCard(){
        java.lang.Boolean result = character.getCanChooseCard();
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testSetChooseCard(){
        character.setChooseCard(Boolean.TRUE);
    }

    @Test
    void testSetCanPLayCard(){
        character.setCanPLayCard(Boolean.TRUE);
    }

    @Test
    void testAddPenality(){
        character.addPenality(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme