package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CardImageTest {
    @Mock
    javafx.scene.image.Image backsideImage;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.CardImage cardImage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFrontCardImage(){
        javafx.scene.image.Image result = CardImage.getFrontCardImage(new com.example.jeux_6_qui_prend.model.Card(0, 0));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme