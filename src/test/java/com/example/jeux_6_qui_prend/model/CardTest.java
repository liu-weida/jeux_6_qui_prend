package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class CardTest {
    com.example.jeux_6_qui_prend.model.Card card= new com.example.jeux_6_qui_prend.model.Card(0, 0);

    @Test
    void testToString(){
        java.lang.String result = card.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testCompareTo(){
        int result = card.compareTo(new com.example.jeux_6_qui_prend.model.Card(0, 0));
        Assertions.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme