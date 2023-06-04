package com.example.jeux_6_qui_prend.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MenuViewTest {
    @Mock
    Button playButton;
    @Mock
    Button quitButton;
    @Mock
    Image titleImage;
    @Mock
    BorderPane component;
    @Mock
    Image backgroundImage1;
    @Mock
    Image backgroundImage2;
    @Mock
    Image backgroundImage3;
    @InjectMocks
    MenuView menuView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme