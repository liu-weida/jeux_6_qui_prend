package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CardSetTest {
    @Mock
    java.util.TreeSet<com.example.jeux_6_qui_prend.model.Card> cards;
    @InjectMocks
    com.example.jeux_6_qui_prend.model.CardSet cardSet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRemains(){
        java.util.Collection<com.example.jeux_6_qui_prend.model.Card> result = cardSet.remains();
        Assertions.assertEquals(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)), result);
    }

    @Test
    void testTake(){
        cardSet.take(new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }

    @Test
    void testRemoveCard(){
        cardSet.removeCard(new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme