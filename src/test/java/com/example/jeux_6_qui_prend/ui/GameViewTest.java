package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class GameViewTest {
    @Mock
    javafx.scene.layout.BorderPane component;
    @Mock
    javafx.scene.layout.HBox cardFrameContainer;
    @Mock
    javafx.scene.layout.VBox contentContainer;
    @Mock
    java.util.ArrayList<com.example.jeux_6_qui_prend.ui.CardView> cardViews;
    @Mock
    java.util.ArrayList<javafx.scene.image.ImageView> deckLocation;
    @Mock
    javafx.scene.layout.StackPane rightStackPane;
    @Mock
    javafx.scene.layout.GridPane rightGridPane;
    @Mock
    javafx.scene.image.Image playerCardFrame;
    @Mock
    java.util.ArrayList<javafx.geometry.Point2D> frameCoordinate;
    @Mock
    javafx.scene.layout.GridPane centerGridPane;
    @Mock
    javafx.scene.layout.HBox cardViewContainer;
    @Mock
    javafx.scene.control.Button play1;
    @Mock
    javafx.scene.control.Button play2;
    @Mock
    javafx.scene.control.Button play3;
    @Mock
    javafx.scene.control.Button play4;
    @Mock
    javafx.scene.control.ComboBox<java.lang.Integer> comboBox;
    @Mock
    java.util.ArrayList<javafx.scene.control.Button> playBtns;
    @Mock
    javafx.scene.image.ImageView backgroundImage;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.GameView gameView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetCardFrame(){
        gameView.setCardFrame(0);
    }

    @Test
    void testSetHandView(){
        gameView.setHandView(new com.example.jeux_6_qui_prend.model.CardSet(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
    }

    @Test
    void testTranslateToFrameCard(){
        gameView.translateToFrameCard(null, new com.example.jeux_6_qui_prend.ui.CardView(null, 0, 0), 0);
    }

    @Test
    void testCardStackView(){
        gameView.cardStackView(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.CardStack(new com.example.jeux_6_qui_prend.model.Card(0, 0)))));
    }

    @Test
    void testSetPlayBtnView(){
        gameView.setPlayBtnView();
    }

    @Test
    void testDeletePlayBtnView(){
        gameView.deletePlayBtnView();
    }

    @Test
    void testSetAiCardView(){
        gameView.setAiCardView(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.model.Card(0, 0))));
    }

    @Test
    void testGetComboBox(){
        javafx.scene.control.ComboBox result = gameView.getComboBox();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeletePlayButton(){
        gameView.deletePlayButton();
    }

    @Test
    void testSetScoreBoard(){
        gameView.setScoreBoard(new java.util.ArrayList<>(java.util.List.of(new com.example.jeux_6_qui_prend.characters.Player())), 0);
    }

    @Test
    void testDeleteCardViewGrid(){
        gameView.deleteCardViewGrid(0);
    }

    @Test
    void testDeleteAllCardViewGrid(){
        gameView.deleteAllCardViewGrid();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme