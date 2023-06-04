package com.example.jeux_6_qui_prend;

import com.example.jeux_6_qui_prend.core.Game;
import com.example.jeux_6_qui_prend.ui.AudioManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    /**
     * Méthode de démarrage de l'application JavaFX.
     *
     * @param stage L'objet Stage principal de l'application.
     * @throws Exception En cas d'erreur lors du démarrage de l'application.
     */
    @Override
    public void start(Stage stage) throws Exception {
        URL startPageUrl = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/startPageBGM.mp3");
        URL gameUrl = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/game.mp3");
        URL buttonClickUrl = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/click.wav");
        URL cardClickUrl = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/cardClick.wav");
        URL cardIntoPile = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/cardIntoPile.wav");
        URL gameOverCheers = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/gameOverCheers.wav");
        URL gameOverFireworks = getClass().getResource("/com/example/jeux_6_qui_prend/BGMs/gameOverFireworks.wav");

        AudioManager.load("startPage", startPageUrl.toString());
        AudioManager.load("game", gameUrl.toString());
        AudioManager.load("buttonClick", buttonClickUrl.toString());
        AudioManager.load("cardClick", cardClickUrl.toString());
        AudioManager.load("cardIntoPile", cardIntoPile.toString());
        AudioManager.load("gameOverCheers", gameOverCheers.toString());
        AudioManager.load("gameOverFireworks", gameOverFireworks.toString());

        Game game = new Game();
        game.run();
    }


    /**
     * Méthode principale pour lancer l'application.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        launch();
    }
}
