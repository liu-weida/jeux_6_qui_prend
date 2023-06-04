package com.example.jeux_6_qui_prend.ui;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PageTransition {

    /**
     * Effectue une transition en fondu entre les nœuds pour une transition en douceur d'une scène à une autre.
     *
     * @param stage Le stage de la scène.
     * @param oldNode Le nœud actuel à masquer.
     * @param onFinished L'action à exécuter une fois la transition terminée.
     */
    public static void smoothTransition(Stage stage, Node oldNode, Runnable onFinished) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), oldNode);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> {
            onFinished.run();

            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), stage.getScene().getRoot());
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fadeOut.play();
    }
}
