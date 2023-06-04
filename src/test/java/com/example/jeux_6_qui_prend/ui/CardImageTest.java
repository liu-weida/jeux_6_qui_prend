package com.example.jeux_6_qui_prend.ui;

import com.example.jeux_6_qui_prend.model.Card;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CardImageTest {
    @Mock
    Image backsideImage;
    @InjectMocks
    CardImage cardImage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFrontCardImage() {
        Image result = CardImage.getFrontCardImage(new Card(0, 0));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme