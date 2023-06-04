package com.example.jeux_6_qui_prend.ui;

import com.example.jeux_6_qui_prend.model.Card;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CardViewTest {
    @Mock
    Pane component;
    @Mock
    StackPane stackFrontOrBack;
    @Mock
    ImageView frontImageView;
    @Mock
    ImageView backImageView;
    @Mock
    Card card;
    @InjectMocks
    CardView cardView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToggleCard() {
        cardView.toggleCard();
    }

    @Test
    void testToString() {
        String result = cardView.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme