package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class MenuViewTest {
    @Mock
    javafx.scene.control.Button playButton;
    @Mock
    javafx.scene.control.Button quitButton;
    @Mock
    javafx.scene.image.Image titleImage;
    @Mock
    javafx.scene.layout.BorderPane component;
    @Mock
    javafx.scene.image.Image backgroundImage1;
    @Mock
    javafx.scene.image.Image backgroundImage2;
    @Mock
    javafx.scene.image.Image backgroundImage3;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.MenuView menuView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme