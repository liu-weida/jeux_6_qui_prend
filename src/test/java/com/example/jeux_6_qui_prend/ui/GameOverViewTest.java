package com.example.jeux_6_qui_prend.ui;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class GameOverViewTest {
    @Mock
    TextField textField;
    @Mock
    ImageView imageView;
    @Mock
    Image gameOver;
    @Mock
    Stage mainStage;
    @Mock
    Scene scene;
    @Mock
    BorderPane component;
    @InjectMocks
    GameOverView gameOverView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme