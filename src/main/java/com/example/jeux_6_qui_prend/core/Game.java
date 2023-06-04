package com.example.jeux_6_qui_prend.core;

import com.example.jeux_6_qui_prend.controller.Controller;
import com.example.jeux_6_qui_prend.ui.MenuView;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {

    int windowHeight = 720;
    int windowWidth = 1366;
    Stage stage;
    Scene menuScene;
    Scene playerCreationScene;
    Scene gameScene;
    Scene endScene;
    private MenuView menuView;
    private BorderPane menuBorderPanel;
    private Controller controller;

    /**
     * Constructeur de la classe de jeu.
     * Initialise la scène de jeu, le titre de la fenêtre et le panneau de bordure du menu.
     * Crée une instance du contrôleur de jeu.
     * Affiche la fenêtre de jeu.
     */
    public Game(){
        this.stage = new Stage();
        stage.setTitle("6 qui prend");
        this.menuBorderPanel = new BorderPane();
        this.controller = new Controller(stage);
        stage.show();
    }

    /**
     * Exécute le jeu en appelant la méthode run() du contrôleur.
     *
     * @throws IOException si une erreur d'entrée/sortie se produit.
     */
    public void run() throws IOException {
        controller.run();
    }
}
