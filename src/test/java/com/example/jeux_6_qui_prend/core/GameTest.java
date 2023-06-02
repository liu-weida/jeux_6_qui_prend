package com.example.jeux_6_qui_prend.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

public class GameTest {
    @Mock
    javafx.stage.Stage stage;
    @Mock
    javafx.scene.Scene menuScene;
    @Mock
    javafx.scene.Scene playerCreationScene;
    @Mock
    javafx.scene.Scene gameScene;
    @Mock
    javafx.scene.Scene endScene;
    @Mock
    com.example.jeux_6_qui_prend.ui.MenuView menuView;
    @Mock
    javafx.scene.layout.BorderPane menuBorderPanel;
    @Mock
    com.example.jeux_6_qui_prend.controller.Controller controller;
    @InjectMocks
    com.example.jeux_6_qui_prend.core.Game game;

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