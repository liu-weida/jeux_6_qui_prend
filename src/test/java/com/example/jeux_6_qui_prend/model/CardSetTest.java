package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static org.mockito.Mockito.*;

class CardSetTest {
    @Mock
    TreeSet<Card> cards;
    @InjectMocks
    CardSet cardSet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRemains() {
        Collection<Card> result = cardSet.remains();
        Assertions.assertEquals(List.of(new Card(0, 0)), result);
    }

    @Test
    void testTake() {
        cardSet.take(new Card(0, 0));
    }

    @Test
    void testRemoveCard() {
        cardSet.removeCard(new Card(0, 0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme