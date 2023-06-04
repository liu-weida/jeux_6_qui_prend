package com.example.jeux_6_qui_prend.controller;

import com.example.jeux_6_qui_prend.ui.GameView;
import com.example.jeux_6_qui_prend.ui.MenuView;
import com.example.jeux_6_qui_prend.ui.PlayerCreationView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ControllerTest {
    @Mock
    Stage stage;
    @Mock
    MenuView menuView;
    @Mock
    PlayerCreationView playerCreationView;
    @Mock
    GameView gameView;
    @Mock
    GameController gameController;
    @Mock
    Scene menuScene;
    @Mock
    Scene playerCreationScene;
    @Mock
    Scene gameScene;
    @InjectMocks
    Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRun() {
        when(menuView.getPlayButton()).thenReturn(null);
        when(menuView.getQuitButton()).thenReturn(null);
        when(playerCreationView.getValidateButton()).thenReturn(null);
        when(playerCreationView.getAiPlayersField()).thenReturn(null);
        when(playerCreationView.getHumanPlayersField()).thenReturn(null);

        controller.run();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme