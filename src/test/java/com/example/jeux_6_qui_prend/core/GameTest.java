package com.example.jeux_6_qui_prend.core;

import com.example.jeux_6_qui_prend.controller.Controller;
import com.example.jeux_6_qui_prend.ui.MenuView;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class GameTest {
    @Mock
    Stage stage;
    @Mock
    Scene menuScene;
    @Mock
    Scene playerCreationScene;
    @Mock
    Scene gameScene;
    @Mock
    Scene endScene;
    @Mock
    MenuView menuView;
    @Mock
    BorderPane menuBorderPanel;
    @Mock
    Controller controller;
    @InjectMocks
    Game game;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRun() throws Exception {
        game.run();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme