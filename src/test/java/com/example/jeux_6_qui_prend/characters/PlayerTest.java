package com.example.jeux_6_qui_prend.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class PlayerTest {
    @Mock
    com.example.jeux_6_qui_prend.model.CardSet hand;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> tbCards;
    @InjectMocks
    com.example.jeux_6_qui_prend.characters.Player player;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddToScore(){
        player.addToScore(0);
    }

    @Test
    void testRemoveCard(){
        player.removeCard(new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }

    @Test
    void testGetCanChooseCard(){
        java.lang.Boolean result = player.getCanChooseCard();
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testSetChooseCard(){
        player.setChooseCard(Boolean.TRUE);
    }

    @Test
    void testSetCanPLayCard(){
        player.setCanPLayCard(Boolean.TRUE);
    }

    @Test
    void testAddPenality(){
        player.addPenality(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme