package com.example.jeux_6_qui_prend.ui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PlayerCreationViewTest {
    @Mock
    StackPane component;
    @Mock
    ImageView backgroundView;
    @Mock
    Button validateButton;
    @Mock
    TextField humanPlayersField;
    @Mock
    TextField aiPlayersField;
    @InjectMocks
    PlayerCreationView playerCreationView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme