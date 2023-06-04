package com.example.jeux_6_qui_prend.ui;

import com.example.jeux_6_qui_prend.model.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class CardView {

    protected Pane component;
    protected StackPane stackFrontOrBack;
    protected ImageView frontImageView;
    protected ImageView backImageView;

    /** may be null if unknown.. forced to back side */
    protected Card card;

    protected boolean frontSide;

    //---------------------------------------------------------------------------------------------

    public CardView(Card card, int width, int height) {
        this.card = card;
        this.frontSide = true;
        if (card == null) {
            this.frontSide = false;
        }
        component = new Pane();
        Image frontImage = CardImage.getFrontCardImage(card);
        Image backImage = CardImage.getBacksideImage();
        frontImageView = new ImageView(frontImage);
        frontImageView.setPreserveRatio(true);
        frontImageView.setFitWidth(width);

        backImageView = new ImageView(backImage);
        backImageView.setPreserveRatio(true);
        backImageView.setFitWidth(width);

        stackFrontOrBack = new StackPane(backImageView, frontImageView);
        component.getChildren().add(stackFrontOrBack);
        component.setPrefSize(width, height);
    }

    public void toggleCard() {
        this.frontSide = !frontSide;
        System.out.println("toggle card " + card + " => " + ((frontSide)? "front" : "back"));
        if (frontSide) {
            frontImageView.setVisible(true);
            backImageView.setVisible(false);
        } else {
            frontImageView.setVisible(false);
            backImageView.setVisible(true);
        }
    }

    //---------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "CardView{" +
                card +
                '}';
    }
    public Pane getComponent(){
        return this.component;
    }

    public ImageView getFrontImageView(){
        return this.backImageView;
    }
}
