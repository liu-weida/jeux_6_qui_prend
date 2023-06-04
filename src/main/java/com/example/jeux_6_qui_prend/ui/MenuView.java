package com.example.jeux_6_qui_prend.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class MenuView {
    private Button playButton;
    private Button quitButton;
    private Image titleImage;
    private BorderPane component;
    private Image backgroundImage1;
    private Image backgroundImage2;
    private Image backgroundImage3;
    public MenuView(){
        AudioManager.setBgm("startPage");
        AudioManager.playBgm();


        this.component = new BorderPane();

        this.playButton = new Button("Play");
        playButton.setPrefSize(328, 78);
        playButton.setTranslateY(98);
        playButton.setTranslateX(0);
        playButton.setOpacity(0);

        this.quitButton = new Button("Quit");
        quitButton.setPrefSize(328, 78);
        quitButton.setTranslateY(140);
        quitButton.setTranslateX(0);
        quitButton.setOpacity(0);

        this.backgroundImage1 = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/startPage1.jpg").toString());
        this.backgroundImage2 = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/startPage2.jpg").toString());
        this.backgroundImage3 = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/startPage3.jpg").toString());

        setBackground(backgroundImage1);

        playButton.setOnMouseEntered(event -> setBackground(backgroundImage2));
        playButton.setOnMouseExited(event -> setBackground(backgroundImage1));
        quitButton.setOnMouseEntered(event -> setBackground(backgroundImage3));
        quitButton.setOnMouseExited(event -> setBackground(backgroundImage1));

        VBox vBox = new VBox(10, playButton, quitButton);
        vBox.setAlignment(Pos.CENTER);
        component.setCenter(vBox);

    }

    public BorderPane getComponent(){
        return this.component;
    }

    public Button getPlayButton(){
        return this.playButton;
    }
    public Button getQuitButton() {
        return this.quitButton;
    }

    private void setBackground(Image image) {
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        component.setBackground(new Background(background));
    }

}
