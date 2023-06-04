package com.example.jeux_6_qui_prend.controller;

import com.example.jeux_6_qui_prend.characters.Ai;
import com.example.jeux_6_qui_prend.characters.Character;
import com.example.jeux_6_qui_prend.characters.Player;
import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardSet;
import com.example.jeux_6_qui_prend.model.CardStack;
import com.example.jeux_6_qui_prend.model.GameModel;
import com.example.jeux_6_qui_prend.ui.CardView;
import com.example.jeux_6_qui_prend.ui.GameOverView;
import com.example.jeux_6_qui_prend.ui.GameView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class GameControllerTest {
    @Mock
    GameModel gameModel;
    @Mock
    GameView gameView;
    @Mock
    Player player;
    @Mock
    List<Ai> aiList;
    @Mock
    List<CardSet> playersCardSet;
    @Mock
    Stage stage;
    @Mock
    Scene gameScene;
    @Mock
    ArrayList<Card> characterCard;
    @Mock
    ArrayList<Card> firstCards;
    @Mock
    ArrayList<Character> characters;
    @Mock
    CardStack cardStack1;
    @Mock
    CardStack cardStack2;
    @Mock
    CardStack cardStack3;
    @Mock
    CardStack cardStack4;
    @Mock
    ArrayList<CardStack> cardStacks;
    @Mock
    Card currentCard;
    @Mock
    GameOverView gameOverView;
    @InjectMocks
    GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartRound() {
        when(gameModel.setFirstPileCards(any())).thenReturn(new ArrayList<>(List.of(new Card(0, 0))));
        when(player.getHand()).thenReturn(new CardSet(List.of(new Card(0, 0))));

        gameController.startRound();
    }

    @Test
    void testUpdateScene() {
        gameController.updateScene();
    }

    @Test
    void testRun() {
        when(gameModel.setFirstPileCards(any())).thenReturn(new ArrayList<>(List.of(new Card(0, 0))));
        when(gameView.getCardViews()).thenReturn(new ArrayList<>(List.of(new CardView(null, 0, 0))));
        when(gameView.getPlayBtns()).thenReturn(new ArrayList<>(List.of(null)));
        when(gameView.getComboBox()).thenReturn(null);
        when(player.getHand()).thenReturn(new CardSet(List.of(new Card(0, 0))));
        when(player.getCanChooseCard()).thenReturn(Boolean.TRUE);
        when(player.getPenality()).thenReturn(0);
        when(cardStack1.getCardCount()).thenReturn(0);
        when(cardStack1.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack1.getTopValue()).thenReturn(0);
        when(cardStack1.getSumPenalty()).thenReturn(0);
        when(cardStack1.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack2.getCardCount()).thenReturn(0);
        when(cardStack2.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack2.getTopValue()).thenReturn(0);
        when(cardStack2.getSumPenalty()).thenReturn(0);
        when(cardStack2.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack3.getCardCount()).thenReturn(0);
        when(cardStack3.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack3.getTopValue()).thenReturn(0);
        when(cardStack3.getSumPenalty()).thenReturn(0);
        when(cardStack3.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack4.getCardCount()).thenReturn(0);
        when(cardStack4.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack4.getTopValue()).thenReturn(0);
        when(cardStack4.getSumPenalty()).thenReturn(0);
        when(cardStack4.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(currentCard.getValue()).thenReturn(0);
        when(gameOverView.getScene()).thenReturn(null);

        gameController.run();
    }

    @Test
    void testPlayerChoseCard() {
        when(gameModel.setFirstPileCards(any())).thenReturn(new ArrayList<>(List.of(new Card(0, 0))));
        when(gameView.getCardViews()).thenReturn(new ArrayList<>(List.of(new CardView(null, 0, 0))));
        when(gameView.getPlayBtns()).thenReturn(new ArrayList<>(List.of(null)));
        when(gameView.getComboBox()).thenReturn(null);
        when(player.getHand()).thenReturn(new CardSet(List.of(new Card(0, 0))));
        when(player.getCanChooseCard()).thenReturn(Boolean.TRUE);
        when(player.getPenality()).thenReturn(0);
        when(cardStack1.getCardCount()).thenReturn(0);
        when(cardStack1.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack1.getTopValue()).thenReturn(0);
        when(cardStack1.getSumPenalty()).thenReturn(0);
        when(cardStack1.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack2.getCardCount()).thenReturn(0);
        when(cardStack2.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack2.getTopValue()).thenReturn(0);
        when(cardStack2.getSumPenalty()).thenReturn(0);
        when(cardStack2.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack3.getCardCount()).thenReturn(0);
        when(cardStack3.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack3.getTopValue()).thenReturn(0);
        when(cardStack3.getSumPenalty()).thenReturn(0);
        when(cardStack3.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack4.getCardCount()).thenReturn(0);
        when(cardStack4.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack4.getTopValue()).thenReturn(0);
        when(cardStack4.getSumPenalty()).thenReturn(0);
        when(cardStack4.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(currentCard.getValue()).thenReturn(0);
        when(gameOverView.getScene()).thenReturn(null);

        gameController.playerChoseCard();
    }

    @Test
    void testAiChooseCard() {
        ArrayList<Card> result = GameController.aiChooseCard(new ArrayList<>(List.of(new CardStack(new Card(0, 0)))));
        Assertions.assertEquals(new ArrayList<>(List.of(new Card(0, 0))), result);
    }

    @Test
    void testResetCharacterCard() {
        gameController.resetCharacterCard();
    }

    @Test
    void testAddCardToPileEvent() {
        when(gameModel.setFirstPileCards(any())).thenReturn(new ArrayList<>(List.of(new Card(0, 0))));
        when(gameView.getCardViews()).thenReturn(new ArrayList<>(List.of(new CardView(null, 0, 0))));
        when(gameView.getPlayBtns()).thenReturn(new ArrayList<>(List.of(null)));
        when(gameView.getComboBox()).thenReturn(null);
        when(player.getHand()).thenReturn(new CardSet(List.of(new Card(0, 0))));
        when(player.getCanChooseCard()).thenReturn(Boolean.TRUE);
        when(player.getPenality()).thenReturn(0);
        when(cardStack1.getCardCount()).thenReturn(0);
        when(cardStack1.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack1.getTopValue()).thenReturn(0);
        when(cardStack1.getSumPenalty()).thenReturn(0);
        when(cardStack1.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack2.getCardCount()).thenReturn(0);
        when(cardStack2.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack2.getTopValue()).thenReturn(0);
        when(cardStack2.getSumPenalty()).thenReturn(0);
        when(cardStack2.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack3.getCardCount()).thenReturn(0);
        when(cardStack3.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack3.getTopValue()).thenReturn(0);
        when(cardStack3.getSumPenalty()).thenReturn(0);
        when(cardStack3.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(cardStack4.getCardCount()).thenReturn(0);
        when(cardStack4.addMayTakeIfBelowOr6th(any())).thenReturn(List.of(new Card(0, 0)));
        when(cardStack4.getTopValue()).thenReturn(0);
        when(cardStack4.getSumPenalty()).thenReturn(0);
        when(cardStack4.getCards()).thenReturn(List.of(new Card(0, 0)));
        when(currentCard.getValue()).thenReturn(0);
        when(gameOverView.getScene()).thenReturn(null);

        gameController.addCardToPileEvent(null);
    }

    @Test
    void testAiPLayCard() {
        gameController.aiPLayCard();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme