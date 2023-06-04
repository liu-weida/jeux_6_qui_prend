package com.example.jeux_6_qui_prend.ui;

import com.example.jeux_6_qui_prend.characters.Character;
import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardSet;
import com.example.jeux_6_qui_prend.model.CardStack;
import com.example.jeux_6_qui_prend.model.Cards;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameView {

    private BorderPane component;
    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 5;
    private static final int RECTANGLE_WIDTH = 80;
    private static final int RECTANGLE_HEIGHT = 122;
    private static final int BORDER_THICKNESS = 4;
    private static final int SPACING = 20;
    int cardWidth = 65;
    int cardHeight = 115;
    private HBox cardFrameContainer;
    private VBox contentContainer;
    private ArrayList<CardView> cardViews;

    private ArrayList<ImageView> deckLocation;
    private StackPane rightStackPane;
    private GridPane rightGridPane;
    private Image playerCardFrame;
    private ArrayList<Point2D> frameCoordinate;
    private GridPane centerGridPane;
    private HBox cardViewContainer;

    private Button play1;
    private Button play2;
    private Button play3;
    private Button play4;
    private ComboBox<Integer> comboBox;

    private ArrayList<Button> playBtns;

    private ImageView backgroundImage;



        public GameView(){

            Image backgroundImage = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/gamePage.jpg").toString());
            BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


            AudioManager.setBgm("game");

            AudioManager.playBgm();


            this.component = new BorderPane();
            this.playerCardFrame = new Image(getClass().getResource("/com/example/jeux_6_qui_prend/images/card/cadre.png").toString());

            component.setBackground(new Background(background));
            //Main du joueur
            cardFrameContainer = new HBox();
            cardFrameContainer.setAlignment(Pos.CENTER);
            cardFrameContainer.setSpacing(10);
            cardFrameContainer.setPadding(new Insets(10));

            for(int i=0;i<10;i++){
                ImageView cardFrameView = new ImageView(playerCardFrame);
                cardFrameContainer.getChildren().add(cardFrameView);
            }
            contentContainer = new VBox(10);
            Label handLabel = new Label("Votre main");
            handLabel.setFont(Font.font("Arial", 16));
            contentContainer.getChildren().addAll(handLabel,cardFrameContainer);
            contentContainer.setAlignment(Pos.CENTER);
            component.setBottom(contentContainer);

            //Grille de jeux
            this.centerGridPane = new GridPane();
            centerGridPane.setAlignment(Pos.CENTER);
            centerGridPane.setHgap(SPACING);
            centerGridPane.setVgap(SPACING);
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    Rectangle rectangle = createRectangle(col == NUM_COLS - 1);
                    centerGridPane.add(rectangle, col, row);
                }
            }
            component.setCenter(centerGridPane);

            //informations sur la partie:
            Label roundLabel = new Label("Manche: ");
            roundLabel.setFont(Font.font("Arial",20));
            //component.setLeft(roundLabel);

            this.cardViews = new ArrayList<CardView>();
            for(Card card: Cards.cards){
                CardView cardView = new CardView(card, cardWidth, cardHeight);
                cardViews.add(cardView);
            }

            this.frameCoordinate = new ArrayList<Point2D>();

            this.play1 = new Button("Certain");
            this.playBtns = new ArrayList<>();
            this.comboBox = new ComboBox<>();
            comboBox.getItems().addAll(1,2,3,4);
            playBtns.add(play1);
            play1.setPrefSize(160, 35);
            play1.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-border-width: 2;-fx-background-radius: 5; -fx-border-radius: 5;");
            play1.setTextFill(Color.BLACK);
            play1.setFont(new Font("Courier New", 16));

            comboBox.setPromptText("Card Piles");
            comboBox.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-text-fill: black;-fx-font-family: 'Courier New'; -fx-font-size: 16;-fx-border-width: 2;-fx-background-radius: 5; -fx-border-radius: 5;");

        }

    /**
     * Crée et renvoie un rectangle avec les dimensions et les propriétés de remplissage appropriées.
     *
     * @param isLastRow Indique si le rectangle fait partie de la dernière ligne.
     * @return Le rectangle créé.
     */
    private Rectangle createRectangle(boolean isLastRow) {
        Rectangle rectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        if (isLastRow) {
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeWidth(BORDER_THICKNESS);
        } else {
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.GRAY);
            rectangle.setStrokeWidth(BORDER_THICKNESS);
        }

        return rectangle;
    }


      public BorderPane getComponent(){
            return this.component;
      }


    /**
     * Définit le cadre des cartes du joueur dans la vue en fonction du nombre spécifié.
     *
     * @param numberFrame Le nombre de cadres de cartes à afficher.
     */
      public void setCardFrame(int numberFrame){
            this.rightGridPane = new GridPane();
            this.rightStackPane = new StackPane();
            for(int i=0; i<numberFrame;i++){
                ImageView cardFrameView = new ImageView(playerCardFrame);
                rightGridPane.add(cardFrameView,0,i);
                rightGridPane.setAlignment(Pos.CENTER);
                rightGridPane.setVgap(10);
            }
            rightStackPane.getChildren().add(rightGridPane);
            rightStackPane.setPadding(new Insets(20));
            rightStackPane.setAlignment(Pos.CENTER_RIGHT);
            component.setRight(rightStackPane);
      }

    /**
     * Affiche la vue de la main du joueur en utilisant le jeu de cartes spécifié.
     *
     * @param hand Le jeu de cartes représentant la main du joueur.
     */
      public void setHandView(CardSet hand){
            ArrayList<ImageView> frameList = new ArrayList<>();
            this.cardViewContainer = new HBox();
            int idx  =0;
            for (Node child : cardFrameContainer.getChildren()) {
                if (child instanceof ImageView) {
                    ImageView frame = (ImageView) child;
                    frameList.add(frame);
                    }
                }
          for (Card card: hand.remains()){
              double positionX = frameList.get(idx).getX();
              double positionY = frameList.get(idx).getY();
              cardViews.get(card.getValue()-1).getComponent().setLayoutX(positionX);
              cardViews.get(card.getValue()-1).getComponent().setLayoutY(positionY);
              cardViewContainer.getChildren().add(cardViews.get(card.value-1).getComponent());
              cardViewContainer.setAlignment(Pos.CENTER);
              cardViewContainer.setSpacing(5);
              cardViewContainer.toFront();
              component.setBottom(cardViewContainer);
              idx+=1;
          }
        }

    public ArrayList<CardView> getCardViews(){
            return this.cardViews;
    }

    /**
     * Anime le déplacement de la carte vers le cadre spécifié.
     *
     * @param e L'événement souris associé au clic sur la carte.
     * @param cardView La vue de la carte à déplacer.
     * @param nbrFrame Le numéro du cadre de destination.
     */
    public void translateToFrameCard(MouseEvent e, CardView cardView, int nbrFrame){
        Pane cardComponent = cardView.getComponent();
        getCoordinate();
        Point2D toPt = new Point2D(frameCoordinate.get(nbrFrame).getX() - cardComponent.localToScene(0, 0).getX() - 25, -(cardComponent.localToScene(0, 0).getY() - frameCoordinate.get(nbrFrame).getY()));

        // create a new ImageView with the same image
        ImageView imageViewCopy = new ImageView();
        imageViewCopy.setImage(cardView.getFrontImageView().getImage());

        Pane cardCopy = new Pane();
        cardCopy.getChildren().add(imageViewCopy);
        cardCopy.setLayoutX(cardComponent.localToScene(0, 0).getX());
        cardCopy.setLayoutY(cardComponent.localToScene(0, 0).getY());
        cardCopy.setTranslateX(cardComponent.getTranslateX());
        cardCopy.setTranslateY(cardComponent.getTranslateY());

        // Assuming that the cardComponent's parent is a Pane.
        // You need to replace with the actual parent node if it's not a Pane.
        Pane parentPane = (Pane) cardComponent.getParent();
        parentPane.getChildren().add(cardCopy);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(cardCopy);
        translateTransition.setDuration(Duration.millis(450));
        translateTransition.setToX(toPt.getX());
        translateTransition.setToY(toPt.getY());

        translateTransition.setOnFinished(event -> {
            System.out.println("Animation terminée");
            HBox hBox = new HBox();
            hBox.getChildren().add(cardComponent);
            hBox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(10, 0, 0, 0));
            rightGridPane.add(hBox, 0, 0);
            // After animation finished, remove the cardCopy from parentPane.
            parentPane.getChildren().remove(cardCopy);
        });

        translateTransition.play();
    }


    /**
     * Récupère les coordonnées des cadres de cartes dans le grille.
     */
    private void getCoordinate(){
        ObservableList<Node> nodes = rightGridPane.getChildren();
        for (Node node : nodes) {
            if (node instanceof ImageView) {
                ImageView imageView = (ImageView) node;
                double imageX = imageView.localToScene(imageView.getBoundsInLocal()).getMinX();
                double imageY = imageView.localToScene(imageView.getBoundsInLocal()).getMinY();
                Point2D coordinate = new Point2D(imageX,imageY);
                frameCoordinate.add(coordinate);
            }
        }
    }

    /**
     * Affiche les piles de cartes dans la vue en utilisant les cartes des piles spécifiées.
     *
     * @param cardStacks Les piles de cartes à afficher.
     */
    public void cardStackView(ArrayList<CardStack> cardStacks){
            int col =0;
            int row =0;
            for(int i=0; i<cardStacks.size();i++){
                for(Card card:cardStacks.get(i).getCards()){
                    HBox hBox = new HBox();
                    hBox.getChildren().add(cardViews.get(card.getValue()-1).getComponent());
                    hBox.setAlignment(Pos.CENTER);
                    hBox.setPadding(new Insets(15, 0, 0, 0));
                    centerGridPane.add(hBox,col,row);
                    col ++;
                }
                row +=1;
                col =0;
            }
    }

    public void setPlayBtnView(){
            centerGridPane.add(play1,7,1);
            centerGridPane.add(comboBox,7,2);
            //centerGridPane.add(play2,5,1);
            //centerGridPane.add(play3,5,2);
            //centerGridPane.add(play4,5,3);
    }

    /**
     * Supprime les boutons de jeu de la vue.
     */
    public void deletePlayBtnView(){
            if(centerGridPane.getChildren().contains(play1)){
                centerGridPane.getChildren().removeAll(play1,play2,play3,play4);
            }
        }

        public ArrayList<Button> getPlayBtns(){
            return this.playBtns;
        }

    /**
     * Affiche les cartes de l'IA dans la vue.
     *
     * @param cards Les cartes de l'IA à afficher.
     */
    public void setAiCardView(ArrayList<Card> cards){
            for(int i=0;i<cards.size();i++){
                HBox hBox = new HBox();
                hBox.getChildren().add(cardViews.get(cards.get(i).getValue() -1).getComponent());
                hBox.setAlignment(Pos.CENTER);
                hBox.setPadding(new Insets(10,0,0,0));
                rightGridPane.add(hBox,0,i+1);
            }
    }

    public ComboBox getComboBox(){
            return  this.comboBox;
    }

    /**
     * Supprime les boutons de jeu de la vue.
     */
    public void deletePlayButton(){
            centerGridPane.getChildren().remove(play1);
            centerGridPane.getChildren().remove(comboBox);
    }

    /**
     * Affiche le tableau des scores dans la vue en utilisant les personnages et le numéro du tour spécifiés.
     *
     * @param characters Les personnages du jeu.
     * @param round Le numéro du tour.
     */
    public void setScoreBoard(ArrayList<Character> characters,int round){
         GridPane gridPane = new GridPane();
         Label label2 = new Label(" " + round);
         label2.setFont(Font.font("Arial",40));
         label2.setTranslateX(160);
         Label label = new Label("Table of penalties");
         label.setTranslateY(10);
         label.setFont(Font.font("Arial",20));
         gridPane.add(label2,0,0);
         gridPane.add(label,0,1);
         int idx =1;
         for (Character character: characters){
             String scoreText = character.getName() +" " + idx +": " +character.getPenality();
             Label label1 = new Label(scoreText);
             label1.setTranslateY(10);
             label1.setFont(Font.font("Arial",20));
             gridPane.add(label1,0,characters.indexOf(character)+2);
             idx+=1;
         }
         component.setLeft(gridPane);
    }

    /**
     * Supprime la vue de la carte dans la grille à la ligne spécifiée.
     *
     * @param row Le numéro de ligne de la grille à supprimer.
     */
    public void deleteCardViewGrid(int row){
        centerGridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == row && node instanceof Pane);
    }

    /**
     * Supprime toutes les vues de cartes de la grille.
     */
    public void deleteAllCardViewGrid(){
            centerGridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && node instanceof Pane);
            centerGridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1 && node instanceof Pane);
            centerGridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2 && node instanceof Pane);
            centerGridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3 && node instanceof Pane);
    }
}
