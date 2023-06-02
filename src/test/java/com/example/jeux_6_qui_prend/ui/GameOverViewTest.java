package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class GameOverViewTest {
    @Mock
    javafx.scene.control.TextField textField;
    @Mock
    javafx.scene.image.ImageView imageView;
    @Mock
    javafx.scene.image.Image gameOver;
    @Mock
    javafx.stage.Stage mainStage;
    @Mock
    javafx.scene.Scene scene;
    @Mock
    javafx.scene.layout.BorderPane component;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.GameOverView gameOverView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme