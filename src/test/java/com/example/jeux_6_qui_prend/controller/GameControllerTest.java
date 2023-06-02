package com.example.jeux_6_qui_prend.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class GameControllerTest {
    @Mock
    com.example.jeux_6_qui_prend.model.GameModel gameModel;
    @Mock
    com.example.jeux_6_qui_prend.ui.GameView gameView;
    @Mock
    com.example.jeux_6_qui_prend.characters.Player player;
    @Mock
    java.util.List<com.example.jeux_6_qui_prend.characters.Ai> aiList;
    @Mock
    java.util.List<com.example.jeux_6_qui_prend.model.CardSet> playersCardSet;
    @Mock
    javafx.stage.Stage stage;
    @Mock
    javafx.scene.Scene gameScene;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> characterCard;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> firstCards;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.characters.Character> characters;
    @Mock
    com.example.jeux_6_qui_prend.model.CardStack cardStack1;
    @Mock
    com.example.jeux_6_qui_prend.model.CardStack cardStack2;
    @Mock
    com.example.jeux_6_qui_prend.model.CardStack cardStack3;
    @Mock
    com.example.jeux_6_qui_prend.model.CardStack cardStack4;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.model.CardStack> cardStacks;
    @Mock
    com.example.jeux_6_qui_prend.model.Card currentCard;
    @Mock
    com.example.jeux_6_qui_prend.ui.GameOverView gameOverView;
    @InjectMocks
    com.example.jeux_6_qui_prend.controller.GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartRound(){
        when(gameModel.setFirstPileCards(any())).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(player.getHand()).thenReturn(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));

        gameController.startRound();
    }

    @Test
    void testUpdateScene(){
        gameController.updateScene();
    }

    @Test
    void testRun(){
        when(gameModel.setFirstPileCards(any())).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(gameView.getCardViews()).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.ui.CardView(null, 0, 0))));
        when(gameView.getPlayBtns()).thenReturn(new java.util.ArrayList<>(java.util.List.of(null)));
        when(gameView.getComboBox()).thenReturn(null);
        when(player.getHand()).thenReturn(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(player.getCanChooseCard()).thenReturn(Boolean.TRUE);
        when(player.getPenality()).thenReturn(0);
        when(cardStack1.getCardCount()).thenReturn(0);
        when(cardStack1.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack1.getTopValue()).thenReturn(0);
        when(cardStack1.getSumPenalty()).thenReturn(0);
        when(cardStack1.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack2.getCardCount()).thenReturn(0);
        when(cardStack2.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack2.getTopValue()).thenReturn(0);
        when(cardStack2.getSumPenalty()).thenReturn(0);
        when(cardStack2.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack3.getCardCount()).thenReturn(0);
        when(cardStack3.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack3.getTopValue()).thenReturn(0);
        when(cardStack3.getSumPenalty()).thenReturn(0);
        when(cardStack3.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack4.getCardCount()).thenReturn(0);
        when(cardStack4.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack4.getTopValue()).thenReturn(0);
        when(cardStack4.getSumPenalty()).thenReturn(0);
        when(cardStack4.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(currentCard.getValue()).thenReturn(0);
        when(gameOverView.getScene()).thenReturn(null);

        gameController.run();
    }

    @Test
    void testPlayerChoseCard(){
        when(gameModel.setFirstPileCards(any())).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(gameView.getCardViews()).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.ui.CardView(null, 0, 0))));
        when(gameView.getPlayBtns()).thenReturn(new java.util.ArrayList<>(java.util.List.of(null)));
        when(gameView.getComboBox()).thenReturn(null);
        when(player.getHand()).thenReturn(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(player.getCanChooseCard()).thenReturn(Boolean.TRUE);
        when(player.getPenality()).thenReturn(0);
        when(cardStack1.getCardCount()).thenReturn(0);
        when(cardStack1.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack1.getTopValue()).thenReturn(0);
        when(cardStack1.getSumPenalty()).thenReturn(0);
        when(cardStack1.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack2.getCardCount()).thenReturn(0);
        when(cardStack2.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack2.getTopValue()).thenReturn(0);
        when(cardStack2.getSumPenalty()).thenReturn(0);
        when(cardStack2.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack3.getCardCount()).thenReturn(0);
        when(cardStack3.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack3.getTopValue()).thenReturn(0);
        when(cardStack3.getSumPenalty()).thenReturn(0);
        when(cardStack3.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack4.getCardCount()).thenReturn(0);
        when(cardStack4.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack4.getTopValue()).thenReturn(0);
        when(cardStack4.getSumPenalty()).thenReturn(0);
        when(cardStack4.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(currentCard.getValue()).thenReturn(0);
        when(gameOverView.getScene()).thenReturn(null);

        gameController.playerChoseCard();
    }

    @Test
    void testAiChooseCard(){
        java.util.ArrayList<com.example.jeux_6_qui_prend.model.Card> result = GameController.aiChooseCard(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardStack(new com.example.jeux_6_qui_prend.model.Card(0, 0)))));
        Assertions.assertEquals(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))), result);
    }

    @Test
    void testResetCharacterCard(){
        gameController.resetCharacterCard();
    }

    @Test
    void testAddCardToPileEvent(){
        when(gameModel.setFirstPileCards(any())).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(gameView.getCardViews()).thenReturn(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.ui.CardView(null, 0, 0))));
        when(gameView.getPlayBtns()).thenReturn(new java.util.ArrayList<>(java.util.List.of(null)));
        when(gameView.getComboBox()).thenReturn(null);
        when(player.getHand()).thenReturn(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
        when(player.getCanChooseCard()).thenReturn(Boolean.TRUE);
        when(player.getPenality()).thenReturn(0);
        when(cardStack1.getCardCount()).thenReturn(0);
        when(cardStack1.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack1.getTopValue()).thenReturn(0);
        when(cardStack1.getSumPenalty()).thenReturn(0);
        when(cardStack1.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack2.getCardCount()).thenReturn(0);
        when(cardStack2.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack2.getTopValue()).thenReturn(0);
        when(cardStack2.getSumPenalty()).thenReturn(0);
        when(cardStack2.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack3.getCardCount()).thenReturn(0);
        when(cardStack3.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack3.getTopValue()).thenReturn(0);
        when(cardStack3.getSumPenalty()).thenReturn(0);
        when(cardStack3.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack4.getCardCount()).thenReturn(0);
        when(cardStack4.addMayTakeIfBelowOr6th(any())).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(cardStack4.getTopValue()).thenReturn(0);
        when(cardStack4.getSumPenalty()).thenReturn(0);
        when(cardStack4.getCards()).thenReturn(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0)));
        when(currentCard.getValue()).thenReturn(0);
        when(gameOverView.getScene()).thenReturn(null);

        gameController.addCardToPileEvent(null);
    }

    @Test
    void testAiPLayCard(){
        gameController.aiPLayCard();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme