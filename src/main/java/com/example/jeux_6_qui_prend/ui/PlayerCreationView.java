package com.example.jeux_6_qui_prend.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PlayerCreationView {

    private StackPane component;
    private ImageView backgroundView;
    private Button validateButton;
    private CenteredTextField humanPlayersField;
    private CenteredTextField aiPlayersField;


    class CenteredTextField extends TextField {
        @Override
        public void positionCaret(int pos) {
            super.positionCaret(this.getText().length() / 2);
        }
    }

    public PlayerCreationView() {
        this.component = new StackPane();

        this.backgroundView = new ImageView();
        this.component.getChildren().add(backgroundView);

        VBox centerBox = new VBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setSpacing(10);
        centerBox.setPadding(new Insets(20));

        Font font = Font.font("Courier New", 20);

        this.humanPlayersField = new CenteredTextField();
        humanPlayersField.setFont(font);
        humanPlayersField.setMaxWidth(290);
        humanPlayersField.setPrefSize(290, 70);
        humanPlayersField.setTranslateY(-30);
        humanPlayersField.setTranslateX(215);
        humanPlayersField.setStyle("-fx-background-color: transparent;");
        humanPlayersField.setAlignment(Pos.CENTER);

        this.aiPlayersField = new CenteredTextField();
        aiPlayersField.setFont(font);
        aiPlayersField.setMaxWidth(290);
        aiPlayersField.setPrefSize(290, 70);
        aiPlayersField.setTranslateY(125);
        aiPlayersField.setTranslateX(215);
        aiPlayersField.setStyle("-fx-background-color: transparent;");
        aiPlayersField.setAlignment(Pos.CENTER);

        this.validateButton = new Button("");
        validateButton.setPrefSize(290, 70);
        validateButton.setTranslateY(222);
        validateButton.setTranslateX(0);
        validateButton.setOpacity(0);

        Image backgroundImage1 = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/nbCharacter1.jpg").toString()); // Replace this with your image path
        Image backgroundImage2 = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/nbCharacter2.jpg").toString()); // Replace this with your image path

        // Set the initial image
        backgroundView.setImage(backgroundImage1);

        validateButton.setOnMouseEntered(event -> backgroundView.setImage(backgroundImage2));
        validateButton.setOnMouseExited(event -> backgroundView.setImage(backgroundImage1));

        centerBox.getChildren().addAll(humanPlayersField, aiPlayersField, validateButton);
        component.getChildren().add(centerBox);
    }

    public StackPane getComponent() {
        return this.component;
    }

    public Button getValidateButton() {
        return this.validateButton;
    }

    public TextField getAiPlayersField() {
        return this.aiPlayersField;
    }

    public TextField getHumanPlayersField() {
        return this.humanPlayersField;
    }

}
