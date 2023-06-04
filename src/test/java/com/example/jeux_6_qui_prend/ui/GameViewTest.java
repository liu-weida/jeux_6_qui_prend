package com.example.jeux_6_qui_prend.ui;

import com.example.jeux_6_qui_prend.characters.Player;
import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardSet;
import com.example.jeux_6_qui_prend.model.CardStack;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class GameViewTest {
    @Mock
    BorderPane component;
    @Mock
    HBox cardFrameContainer;
    @Mock
    VBox contentContainer;
    @Mock
    ArrayList<CardView> cardViews;
    @Mock
    ArrayList<ImageView> deckLocation;
    @Mock
    StackPane rightStackPane;
    @Mock
    GridPane rightGridPane;
    @Mock
    Image playerCardFrame;
    @Mock
    ArrayList<Point2D> frameCoordinate;
    @Mock
    GridPane centerGridPane;
    @Mock
    HBox cardViewContainer;
    @Mock
    Button play1;
    @Mock
    Button play2;
    @Mock
    Button play3;
    @Mock
    Button play4;
    @Mock
    ComboBox<Integer> comboBox;
    @Mock
    ArrayList<Button> playBtns;
    @Mock
    ImageView backgroundImage;
    @InjectMocks
    GameView gameView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetCardFrame() {
        gameView.setCardFrame(0);
    }

    @Test
    void testSetHandView() {
        gameView.setHandView(new CardSet(List.of(new Card(0, 0))));
    }

    @Test
    void testTranslateToFrameCard() {
        gameView.translateToFrameCard(null, new CardView(null, 0, 0), 0);
    }

    @Test
    void testCardStackView() {
        gameView.cardStackView(new ArrayList<>(List.of(new CardStack(new Card(0, 0)))));
    }

    @Test
    void testSetPlayBtnView() {
        gameView.setPlayBtnView();
    }

    @Test
    void testDeletePlayBtnView() {
        gameView.deletePlayBtnView();
    }

    @Test
    void testSetAiCardView() {
        gameView.setAiCardView(new ArrayList<>(List.of(new Card(0, 0))));
    }

    @Test
    void testGetComboBox() {
        ComboBox result = gameView.getComboBox();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeletePlayButton() {
        gameView.deletePlayButton();
    }

    @Test
    void testSetScoreBoard() {
        gameView.setScoreBoard(new ArrayList<>(List.of(new Player())), 0);
    }

    @Test
    void testDeleteCardViewGrid() {
        gameView.deleteCardViewGrid(0);
    }

    @Test
    void testDeleteAllCardViewGrid() {
        gameView.deleteAllCardViewGrid();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme