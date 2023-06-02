package com.example.jeux_6_qui_prend.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class GameModelTest {
    com.example.jeux_6_qui_prend.model.GameModel gameModel= new com.example.jeux_6_qui_prend.model.GameModel();

    @Test
    void testRemoveCharacterCard(){
        gameModel.removeCharacterCard(new com.example.jeux_6_qui_prend.characters.Player(), new com.example.jeux_6_qui_prend.model.Card(0, 0));
    }

    @Test
    void testPlayOrder(){
        java.util.ArrayList<com.example.jeux_6_qui_prend.characters.Character> result = gameModel.playOrder(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))), new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.characters.Player())));
        Assertions.assertEquals(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.characters.Player())), result);
    }

    @Test
    void testCardOrder(){
        java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> result = gameModel.cardOrder(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        Assertions.assertEquals(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))), result);
    }

    @Test
    void testIsCardPresent(){
        boolean result = GameModel.isCardPresent(new com.example.jeux_6_qui_prend.model.Card(0, 0), java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSortCard(){
        java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> result = gameModel.sortCard(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        Assertions.assertEquals(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))), result);
    }

    @Test
    void testSetFirstPileCards(){
        java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> result = gameModel.setFirstPileCards(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.characters.Player())));
        Assertions.assertEquals(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))), result);
    }

    @Test
    void testClearAllCardStack(){
        gameModel.clearAllCardStack(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardStack(new com.example.jeux_6_qui_prend.model.Card(0, 0)))));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme