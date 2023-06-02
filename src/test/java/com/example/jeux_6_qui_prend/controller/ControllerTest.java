package com.example.jeux_6_qui_prend.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class ControllerTest {
    @Mock
    javafx.stage.Stage stage;
    @Mock
    com.example.jeux_6_qui_prend.ui.MenuView menuView;
    @Mock
    com.example.jeux_6_qui_prend.ui.PlayerCreationView playerCreationView;
    @Mock
    com.example.jeux_6_qui_prend.ui.GameView gameView;
    @Mock
    com.example.jeux_6_qui_prend.controller.GameController gameController;
    @Mock
    javafx.scene.Scene menuScene;
    @Mock
    javafx.scene.Scene playerCreationScene;
    @Mock
    javafx.scene.Scene gameScene;
    @InjectMocks
    com.example.jeux_6_qui_prend.controller.Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRun(){
        when(menuView.getPlayButton()).thenReturn(null);
        when(menuView.getQuitButton()).thenReturn(null);
        when(playerCreationView.getValidateButton()).thenReturn(null);
        when(playerCreationView.getAiPlayersField()).thenReturn(null);
        when(playerCreationView.getHumanPlayersField()).thenReturn(null);

        controller.run();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme