package com.example.jeux_6_qui_prend.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class GameOverView {

    private Label textField;
    private ImageView imageView;
    private Image gameOver;
    private Stage mainStage;
    private String[] dialogues = {};
    private int currentDialogue = 0;
    private Scene scene;
    private BorderPane component;

    public GameOverView() {

        this.component = new BorderPane();

        AudioManager.setBgm("gameOverCheers");
        AudioManager.playBgm();
        AudioManager.play("gameOverFireworks");

        InputStream input1 = getClass().getResourceAsStream("/com/example/jeux_6_qui_prend/images/gameOver.jpg");
        gameOver = new Image(input1);
        imageView = new ImageView(gameOver);

        textField = new Label();
        Font font = Font.font("Courier New", 20);
        textField.setFont(font);
        textField.setMaxWidth(290);
        textField.setPrefSize(290, 70);
        textField.setTranslateY(65);
        textField.setTranslateX(0);
        textField.setStyle("-fx-background-color: transparent;");
        textField.setDisable(true);
        textField.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane(imageView, textField);
        this.scene = new Scene(stackPane, 1366, 768);

        EventHandler<KeyEvent> keyEventEventHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                nextDialogue();
            }
        };

        EventHandler<MouseEvent> mouseEventEventHandler = event -> {
            nextDialogue();
        };

        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEventEventHandler);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventEventHandler);
    }

    public Scene getScene() {
        return this.scene;
    }

    private void nextDialogue() {
        if (currentDialogue < dialogues.length) {
            textField.setText(dialogues[currentDialogue]);
            currentDialogue++;
        } else {
            showNextScene();
        }
    }

    private void showNextScene() {
        System.exit(0);
    }

    public BorderPane getComponent(){
        return this.component;
    }

    public void setLabel(String name){
        this.textField.setText(name);
    }

}
