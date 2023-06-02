package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CardViewTest {
    @Mock
    javafx.scene.layout.Pane component;
    @Mock
    javafx.scene.layout.StackPane stackFrontOrBack;
    @Mock
    javafx.scene.image.ImageView frontImageView;
    @Mock
    javafx.scene.image.ImageView backImageView;
    @Mock
    com.example.jeux_6_qui_prend.model.Card card;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.CardView cardView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToggleCard(){
        cardView.toggleCard();
    }

    @Test
    void testToString(){
        java.lang.String result = cardView.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme