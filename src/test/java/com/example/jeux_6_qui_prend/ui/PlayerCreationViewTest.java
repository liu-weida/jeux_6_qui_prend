package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class PlayerCreationViewTest {
    @Mock
    javafx.scene.layout.StackPane component;
    @Mock
    javafx.scene.image.ImageView backgroundView;
    @Mock
    javafx.scene.control.Button validateButton;
    @Mock
    javafx.scene.control.TextField humanPlayersField;
    @Mock
    javafx.scene.control.TextField aiPlayersField;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.PlayerCreationView playerCreationView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme