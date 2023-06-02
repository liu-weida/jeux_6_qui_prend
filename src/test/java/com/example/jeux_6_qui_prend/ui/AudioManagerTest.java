package com.example.jeux_6_qui_prend.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class AudioManagerTest {
    @Mock
    java.util.Map<java.lang.String,javafx.scene.media.MediaPlayer> mediaPlayers;
    @InjectMocks
    com.example.jeux_6_qui_prend.ui.AudioManager audioManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoad(){
        AudioManager.load("name", "mediaUrl");
    }

    @Test
    void testPlay(){
        AudioManager.play("name");
    }

    @Test
    void testStop(){
        AudioManager.stop("name");
    }

    @Test
    void testSetBgm(){
        AudioManager.setBgm("name");
    }

    @Test
    void testPlayBgm(){
        AudioManager.playBgm();
    }

    @Test
    void testStopBgm(){
        AudioManager.stopBgm();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme