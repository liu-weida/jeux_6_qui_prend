package com.example.jeux_6_qui_prend.ui;

import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {
    private static Map<String, MediaPlayer> mediaPlayers = new HashMap<>();
    private static MediaPlayer bgmPlayer;

    /**
     * Charge un fichier multimédia à partir de l'URL spécifiée et le lie à un nom donné.
     *
     * @param name Le nom associé au fichier multimédia.
     * @param mediaUrl L'URL du fichier multimédia à charger.
     */
    public static void load(String name, String mediaUrl) {
        Media media = new Media(mediaUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayers.put(name, mediaPlayer);
    }

    /**
     * Joue le fichier multimédia associé au nom spécifié.
     *
     * @param name Le nom du fichier multimédia à jouer.
     */
    public static void play(String name) {
        MediaPlayer mediaPlayer = mediaPlayers.get(name);
        if (mediaPlayer != null) {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        }
    }

    /**
     * Arrête la lecture du fichier multimédia associé au nom spécifié.
     *
     * @param name Le nom du fichier multimédia à arrêter.
     */
    public static void stop(String name) {
        MediaPlayer mediaPlayer = mediaPlayers.get(name);
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    /**
     * Définit le fichier multimédia associé au nom spécifié comme musique de fond (BGM).
     *
     * @param name Le nom du fichier multimédia à utiliser comme BGM.
     */
    public static void setBgm(String name) {
        bgmPlayer = mediaPlayers.get(name);
        if (bgmPlayer != null) {
            bgmPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Enable loop
        }
    }

    /**
     * Joue la musique de fond (BGM) actuellement définie.
     */
    public static void playBgm() {
        if(bgmPlayer != null) {
            bgmPlayer.play();
        }
    }

    /**
     * Arrête la lecture de la musique de fond (BGM) actuellement en cours.
     */
    public static void stopBgm() {
        if(bgmPlayer != null) {
            bgmPlayer.stop();
        }
    }
}
