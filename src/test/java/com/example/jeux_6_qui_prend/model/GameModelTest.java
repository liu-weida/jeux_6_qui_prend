package com.example.jeux_6_qui_prend.model;

import com.example.jeux_6_qui_prend.characters.Character;
import com.example.jeux_6_qui_prend.characters.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameModelTest {
    GameModel gameModel = new GameModel();

    @Test
    void testRemoveCharacterCard() {
        gameModel.removeCharacterCard(new Player(), new Card(0, 0));
    }

    @Test
    void testPlayOrder() {
        ArrayList<Character> result = gameModel.playOrder(new ArrayList<>(List.of(new Card(0, 0))), new ArrayList<>(List.of(new Player())));
        Assertions.assertEquals(new ArrayList<>(List.of(new Player())), result);
    }

    @Test
    void testCardOrder() {
        ArrayList<Card> result = gameModel.cardOrder(new ArrayList<>(List.of(new Card(0, 0))));
        Assertions.assertEquals(new ArrayList<>(List.of(new Card(0, 0))), result);
    }

    @Test
    void testIsCardPresent() {
        boolean result = GameModel.isCardPresent(new Card(0, 0), List.of(new Card(0, 0)));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSortCard() {
        ArrayList<Card> result = gameModel.sortCard(new ArrayList<>(List.of(new Card(0, 0))));
        Assertions.assertEquals(new ArrayList<>(List.of(new Card(0, 0))), result);
    }

    @Test
    void testSetFirstPileCards() {
        ArrayList<Card> result = gameModel.setFirstPileCards(new ArrayList<>(List.of(new Player())));
        Assertions.assertEquals(new ArrayList<>(List.of(new Card(0, 0))), result);
    }

    @Test
    void testClearAllCardStack() {
        gameModel.clearAllCardStack(new ArrayList<>(List.of(new CardStack(new Card(0, 0)))));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme