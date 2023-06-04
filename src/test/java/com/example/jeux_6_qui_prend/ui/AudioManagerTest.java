package com.example.jeux_6_qui_prend.ui;

import javafx.scene.media.MediaPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

class AudioManagerTest {
    @Mock
    Map<String, MediaPlayer> mediaPlayers;
    @InjectMocks
    AudioManager audioManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoad() {
        AudioManager.load("name", "mediaUrl");
    }

    @Test
    void testPlay() {
        AudioManager.play("name");
    }

    @Test
    void testStop() {
        AudioManager.stop("name");
    }

    @Test
    void testSetBgm() {
        AudioManager.setBgm("name");
    }

    @Test
    void testPlayBgm() {
        AudioManager.playBgm();
    }

    @Test
    void testStopBgm() {
        AudioManager.stopBgm();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme