package com.example.jeux_6_qui_prend.controller;

import com.example.jeux_6_qui_prend.characters.Ai;
import com.example.jeux_6_qui_prend.characters.Character;
import com.example.jeux_6_qui_prend.characters.Player;
import com.example.jeux_6_qui_prend.model.*;
import com.example.jeux_6_qui_prend.ui.AudioManager;
import com.example.jeux_6_qui_prend.ui.CardView;
import com.example.jeux_6_qui_prend.ui.GameOverView;
import com.example.jeux_6_qui_prend.ui.GameView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GameController {
    private static GameModel gameModel;
    private static GameView gameView;
    private final Player player;
    private static final List<Ai> aiList = new ArrayList<Ai>();
    private List<CardSet> playersCardSet;
    private final int numberPlayer;
    private final Stage stage;
    private final Scene gameScene;
    private static ArrayList<Card> characterCard;
    private ArrayList<Card> firstCards;
    private ArrayList<Character> characters;
    private CardStack cardStack1;
    private CardStack cardStack2;
    private CardStack cardStack3;
    private CardStack cardStack4;
    private static ArrayList<CardStack> cardStacks;

    private Card currentCard;
    private boolean otherCanPlay = false;

    private GameOverView gameOverView;

    private int round;


    public GameController(GameView gameView,int aiNumber, Stage stage, Scene gameScene){
        gameModel = new GameModel();
        GameController.gameView = gameView;
        this.player = new Player();
        this.stage=stage;
        this.gameScene = gameScene;
        characterCard = new ArrayList<>();
        this.firstCards = new ArrayList<>();
        this.cardStacks = new ArrayList<>();
        this.characters = new ArrayList<>();
        characters.add(player);
        for(int i=0;i<aiNumber;i++){
            Ai ai = new Ai();
            aiList.add(ai);
            characters.add(ai);
        }
        this.numberPlayer = aiNumber +1;
        this.round =1;

    }

    /**
     * Démarre un nouveau tour de jeu.
     * Distribue les cartes aux joueurs, configure les piles de cartes et met à jour la scène du jeu.
     */
    public void startRound(){
        Random random = new Random();
        gameView.setScoreBoard(characters,round);
        playersCardSet = Cards.distributeRandomCards(numberPlayer,random);
        player.setHand(playersCardSet.get(0));
        for(int i=1;i<playersCardSet.size();i++){
           aiList.get(i-1).setHand(playersCardSet.get(i));
        }
        for(int i=0; i<playersCardSet.size();i++){
            System.out.println(playersCardSet.get(i).remains());
        }
        gameView.setCardFrame(numberPlayer);
        gameView.setHandView(player.getHand());
        firstCards = gameModel.setFirstPileCards(characters);
        this.cardStack1 = new CardStack(firstCards.get(0));
        this.cardStack2 = new CardStack(firstCards.get(1));
        this.cardStack3 = new CardStack(firstCards.get(2));
        this.cardStack4 = new CardStack(firstCards.get(3));
        cardStacks.add(cardStack1);
        cardStacks.add(cardStack2);
        cardStacks.add(cardStack3);
        cardStacks.add(cardStack4);
        gameView.cardStackView(cardStacks);
        updateScene();
    }

    /**
     * Met à jour la scène du jeu en changeant la scène actuelle pour la scène du jeu.
     */
    public  void updateScene(){
        stage.setScene(gameScene);
    }

    /**
     * Exécute le déroulement du jeu en démarrant un nouveau tour, mettant à jour la scène du jeu,
     * puis permettant au joueur de choisir une carte.
     */
    public void run(){
        startRound();
        updateScene();
        playerChoseCard();
    }

    /**
     * Permet au joueur de choisir une carte en cliquant sur une carte de sa main.
     * Associe une action de sélection de carte à chaque carte de la main du joueur.
     */
    public void playerChoseCard(){
        AudioManager.play("cardClick");
        ArrayList<CardView> cardViews = gameView.getCardViews();
            for (Card card: player.getHand().remains()){
                    Pane cardComponent = cardViews.get(card.getValue() - 1).getComponent();
                    cardComponent.setOnMouseClicked(e -> playerChooseCardAction(e, cardViews, player, card));
            }


    }

    /**
     * Réalise l'action de sélection de carte par le joueur en réponse à un événement de souris.
     * Vérifie si un personnage a atteint une pénalité de 66 points ou plus, et affiche l'écran de fin de partie si c'est le cas.
     * Effectue la translation de la carte sélectionnée vers le cadre de la carte.
     * Supprime la carte sélectionnée du joueur et l'ajoute à la liste des cartes du personnage.
     * Joue un effet sonore de sélection de carte.
     * Permet à l'IA de choisir une carte à son tour.
     * Définit la carte sélectionnée comme la carte courante.
     * Met à jour la vue pour afficher le bouton de jeu.
     * Ajoute un gestionnaire d'événements pour jouer la carte lorsque le bouton est cliqué.
     * Supprime la carte sélectionnée de la main du joueur.
     * Désactive la possibilité de sélectionner une carte pour le joueur.
     * Active la possibilité de jouer une carte pour le joueur.
     */
    private void playerChooseCardAction(MouseEvent e, ArrayList<CardView> cardViews, Player player, Card card){
        int minvalue = Integer.MAX_VALUE;
        String characterName = "";
        for(Character character: characters) {
            if (character.getPenality() < minvalue) {
                minvalue = character.getPenality();
                characterName = character.getName();
            }
        }
        for(Character character: characters){
            if(character.getPenality() >=66){
                this.gameOverView = new GameOverView();
                gameOverView.setLabel(characterName);
                stage.setScene(gameOverView.getScene());
            }
        }

        if(player.getCanChooseCard()) {
            gameView.translateToFrameCard(e, cardViews.get(card.getValue() - 1), 0);
            gameModel.removeCharacterCard(player, card);
            characterCard.add(card);
            AudioManager.play("cardClick");
            aiChooseCard(cardStacks);
            currentCard = characterCard.get(0);
            System.out.println("LISTE DES CARTES CHARACTERES" + characterCard.get(0) +characterCard.get(1) + characterCard.get(2));
            gameView.setPlayBtnView();
            addCardToPileEvent(gameView.getPlayBtns().get(0));
            player.getHand().removeCard(currentCard);
            player.setChooseCard(false);
            player.setCanPLayCard(true);

        }

    }

    /**
     * Permet aux IA de choisir une carte à jouer en fonction des tas de cartes donnés.
     * Ajoute les cartes choisies à une liste de cartes de l'IA et à la liste globale des cartes de personnage.
     * Met à jour la vue pour afficher les cartes choisies par l'IA.
     *
     * @param cardStacks Les tas de cartes parmi lesquels les IA doivent choisir.
     * @return La liste des cartes choisies par les IA.
     */
    public static ArrayList<Card> aiChooseCard(ArrayList<CardStack> cardStacks){
        ArrayList<Card> aiCardsChoice = new ArrayList<>();
        for(Ai ai: aiList){
            Card cardChoice = ai.selectCard(cardStacks);
            aiCardsChoice.add(cardChoice);
            characterCard.add(cardChoice);
            ai.removeCard(cardChoice);
        }
        gameView.setAiCardView(aiCardsChoice);
        return aiCardsChoice;
    }

    /**
     * Réinitialise la liste des cartes de personnage en la vidant.
     */
    public void resetCharacterCard(){
        characterCard.clear();
    }

    /**
     * Ajoute un gestionnaire d'événements au bouton de jeu pour jouer la carte sélectionnée dans une pile.
     *
     * @param playButton Le bouton de jeu.
     */
    public void addCardToPileEvent(Button playButton){

        ComboBox comboBox = gameView.getComboBox();
        playButton.setOnAction(actionEvent -> {
                    AudioManager.play("cardClick");
                    if(currentCard != null){
                        Integer value = (Integer) comboBox.getValue();
                        CardStack cardStack = cardStacks.get(value - 1);
                        if(cardStack.getCardCount() ==5){

                            AudioManager.play("cardIntoPile");

                            gameView.deleteCardViewGrid(value -1);
                            player.addPenality(cardStack.getSumPenalty());
                        }
                        if(cardStack.getTopValue() >= currentCard.getValue() && cardStack.getCardCount() !=5){

                            AudioManager.play("cardIntoPile");

                            gameView.deleteCardViewGrid(value -1);
                            player.addPenality(cardStack.getSumPenalty());
                        }
                        cardStack.addMayTakeIfBelowOr6th(currentCard);
                        aiPLayCard();
                        resetCharacterCard();
                        gameView.cardStackView(cardStacks);
                        gameView.deletePlayButton();
                        gameView.setCardFrame(numberPlayer);
                        gameView.setScoreBoard(characters,round);
                        player.setChooseCard(true);
                        if(player.getHand().remains().size() < 1){
                            this.round +=1;
                            gameView.deleteAllCardViewGrid();
                            gameModel.clearAllCardStack(cardStacks);
                            resetCharacterCard();
                            cardStacks.clear();
                            run();
                        }
                        currentCard = null;
                        System.out.println("pile 1" +cardStacks.get(0).getCards());
                        System.out.println("pile 2" + cardStacks.get(1).getCards());
                        System.out.println("pile 3" +cardStacks.get(2).getCards());
                        System.out.println("pile 4 "+cardStacks.get(3).getCards());
                        System.out.println("main du joueur" + player.getHand().remains());
                        System.out.println("Main de l'ia 1 " + aiList.get(0).getHand().remains());
                        System.out.println("Main de l'ia 2 " + aiList.get(1).getHand().remains());
                    }

                });

        }

    /**
     * Permet aux IA de jouer leurs cartes en fonction des tas de cartes et des cartes de personnage actuelles.
     * Chaque IA joue une carte en utilisant la méthode playCard(), en passant les tas de cartes, et la carte correspondante de la liste des cartes de personnage.
     * Affiche des informations de débogage sur l'indice de la carte de l'IA.
     */
        public void aiPLayCard(){
        int idx =1;
        for(Card card: characterCard){
            System.out.println(card);
        }
        for(Ai ai: aiList){
                ai.playCard(cardStacks,characterCard.get(idx),gameView);
                System.out.println("Indice carte ia: " + idx);
                idx +=1;
            }
        }
}




