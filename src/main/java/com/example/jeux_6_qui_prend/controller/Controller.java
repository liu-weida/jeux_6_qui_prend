package com.example.jeux_6_qui_prend.controller;

import com.example.jeux_6_qui_prend.ui.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private MenuView menuView;
    private PlayerCreationView playerCreationView;

    private GameView gameView;

    private GameController gameController;

    private final int windowHeight = 768;
    private final int windowWidth = 1366;

    private Scene menuScene;
    private Scene playerCreationScene;
    private Scene gameScene;

    public Controller(Stage stage){
        this.stage = stage;
        this.menuView = new MenuView();
        this.playerCreationView = new PlayerCreationView();
        this.gameView = new GameView();
        this.menuScene = new Scene(menuView.getComponent(),this.windowWidth,this.windowHeight);
        this.playerCreationScene = new Scene(playerCreationView.getComponent(),this.windowWidth,this.windowHeight);
        this.gameScene = new Scene(gameView.getComponent(), this.windowWidth, this.windowHeight);

    }

    /**
     * Exécute le programme en affichant la scène du menu et en configurant les gestionnaires d'événements.
     */
    public void run(){
        stage.setScene(menuScene);
        setupEventHandlers();
    }

    /**
     * Configure les gestionnaires d'événements pour les boutons du menu et de la création de joueurs.
     */
    private void setupEventHandlers(){
        menuView.getPlayButton().setOnAction(event ->{
            AudioManager.play("buttonClick");
            PageTransition.smoothTransition(stage, stage.getScene().getRoot(), () -> {
                stage.setScene(this.playerCreationScene);
            });
        });
        menuView.getQuitButton().setOnAction(event -> {
            AudioManager.play("buttonClick");
            PageTransition.smoothTransition(stage, stage.getScene().getRoot(), () -> {
                System.exit(0);
            });
        });

        playerCreationView.getValidateButton().setOnAction(event ->{
            AudioManager.play("buttonClick");
            AudioManager.stopBgm();

            int numberHumanPlayer = Integer.parseInt(playerCreationView.getHumanPlayersField().getText());
            int numberAiPlayer = Integer.parseInt(playerCreationView.getAiPlayersField().getText());
            if (numberAiPlayer + numberHumanPlayer <= 10) {
                // Effectuer l'action souhaitée
                System.out.println("Nombre de joueurs humains: " + numberHumanPlayer);
                System.out.println("Nombre de joueurs non humains: " + numberAiPlayer);
                this.gameController = new GameController(gameView,numberAiPlayer,stage,gameScene);
                PageTransition.smoothTransition(stage, stage.getScene().getRoot(), () -> {
                    stage.setScene(gameScene);
                    gameController.run();
                });

            } else {
                // Afficher une alerte si la somme des joueurs dépasse 10
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("La somme des joueurs ne doit pas dépasser 10");
                alert.showAndWait();
            }
        });
    }
}
