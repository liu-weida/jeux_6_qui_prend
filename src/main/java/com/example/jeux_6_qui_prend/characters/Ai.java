package com.example.jeux_6_qui_prend.characters;

import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardStack;
import com.example.jeux_6_qui_prend.model.GameModel;
import com.example.jeux_6_qui_prend.ui.CardView;
import com.example.jeux_6_qui_prend.ui.GameView;

import java.util.ArrayList;
import java.util.Random;

public class Ai extends Character{


    public Ai(){
       this.isAi = true;
       this.tbCards = new ArrayList<>();
       this.sumPenality =0;
       this.name = "IA";
    }

    /**
     * Sélectionne une carte à jouer à partir des tas de cartes donnés.
     *
     * @param cardStacks Les tas de cartes parmi lesquels choisir.
     * @return La carte sélectionnée.
     */
    public Card selectCard(ArrayList<CardStack> cardStacks){
        Card cardChoice = new Card(0,0);
        ArrayList<Card> possibleChoice = new ArrayList<>();
        Random random = new Random();
        int topValuePile1;
        int topValuePile2;
        int topValuePile3;
        int topValuePile4;

        topValuePile1 = cardStacks.get(0).getTopValue();
        topValuePile2  = cardStacks.get(1).getTopValue();
        topValuePile3 = cardStacks.get(2).getTopValue();
        topValuePile4 = cardStacks.get(3).getTopValue();

        int minValue = Math.min(Math.min(Math.min(topValuePile1,topValuePile2),topValuePile3),topValuePile4);

        for (Card card: hand.remains()){
            if(card.getValue() >= minValue){
                possibleChoice.add(card);
            }
        }
        if(possibleChoice.size() !=0){
            cardChoice = possibleChoice.get(random.nextInt(possibleChoice.size()));
        }
        else{
            int randomIndex = new Random().nextInt(hand.remains().size());
            int currentIndex = 0;
            for (Card card : hand.remains()) {
                if (currentIndex == randomIndex) {
                    cardChoice = card;
                }
                currentIndex++;
            }
        }

        System.out.println("L'IA CHOSIIT LA CARTE" + cardChoice.getValue());
        return cardChoice;
    }

    /**
     * Joue une carte dans les tas de cartes donnés.
     *
     * @param cardStacks Les tas de cartes dans lesquels jouer la carte.
     * @param card       La carte à jouer.
     * @param gameView   La vue du jeu.
     */
    public void playCard(ArrayList<CardStack> cardStacks,Card card,GameView gameView){
        int topValuePile1;
        int topValuePile2;
        int topValuePile3;
        int topValuePile4;

        topValuePile1 = cardStacks.get(0).getTopValue();
        topValuePile2  = cardStacks.get(1).getTopValue();
        topValuePile3 = cardStacks.get(2).getTopValue();
        topValuePile4 = cardStacks.get(3).getTopValue();

        int[] lastCards = new int[]{topValuePile1, topValuePile2, topValuePile3, topValuePile4};

        ArrayList<Integer> validValues = new ArrayList<>();
        // Parcourir les piles et sélectionner les valeurs inférieures à la valeur de la carte
        for (CardStack stack : cardStacks) {
            int topValue = stack.getTopValue();
            if (topValue < card.getValue()) {
                validValues.add(topValue);
            }
        }

        int diff = Integer.MAX_VALUE;
        int closeValue = -1;
        int idx = 0;

        if(validValues.size() ==0){
            for (CardStack stack : cardStacks) {
                int topValue = stack.getTopValue();
                int difference = Math.abs(card.getValue() - topValue);
                if(difference < diff){
                    closeValue = topValue;
                    diff = difference;
                }
            }
            for (int i = 0; i < lastCards.length; i++) {
                if (lastCards[i] == closeValue) {
                    idx = i;
                    break;
                }
            }
            if(cardStacks.get(idx).getCardCount() ==5){
                gameView.deleteCardViewGrid(idx);
                addPenality(cardStacks.get(idx).getSumPenalty());
            }
            if(cardStacks.get(idx).getTopValue() >= card.getValue() && cardStacks.get(idx).getCardCount() !=5){
                gameView.deleteCardViewGrid(idx);
                addPenality(cardStacks.get(idx).getSumPenalty());
            }
            cardStacks.get(idx).addMayTakeIfBelowOr6th(card);
            System.out.println("L'IA JOUE " + card + "au stack numero " + idx);
        }

        else{
            int closestValue = -1;
            int smallestDifference = Integer.MAX_VALUE;

            for (int value : validValues) {
                int difference = Math.abs(card.getValue() - value);
                if (difference < smallestDifference) {
                    closestValue = value;
                    smallestDifference = difference;
                }

            }


            int deckIndex = -1;

            for (int i = 0; i < lastCards.length; i++) {
                if (lastCards[i] == closestValue) {
                    deckIndex = i;
                    break;
                }
            }
            System.out.println("L'IA JOUE " + card+ "au stack numero " + deckIndex );
            switch (deckIndex){
                case 0:
                    if(cardStacks.get(0).getCardCount() ==5){
                        gameView.deleteCardViewGrid(0);
                        addPenality(cardStacks.get(0).getSumPenalty());
                    }
                    if(cardStacks.get(0).getTopValue() >= card.getValue() && cardStacks.get(0).getCardCount() !=5){
                        gameView.deleteCardViewGrid(0);
                        addPenality(cardStacks.get(0).getSumPenalty());
                    }
                    cardStacks.get(0).addMayTakeIfBelowOr6th(card);
                    break;
                case 1:
                    if(cardStacks.get(1).getCardCount() ==5){
                        gameView.deleteCardViewGrid(1);
                        addPenality(cardStacks.get(1).getSumPenalty());
                    }
                    if(cardStacks.get(1).getTopValue() >= card.getValue() && cardStacks.get(1).getCardCount() !=5){
                        gameView.deleteCardViewGrid(1);
                        addPenality(cardStacks.get(1).getSumPenalty());
                    }
                    cardStacks.get(1).addMayTakeIfBelowOr6th(card);
                    break;
                case 2:
                    if(cardStacks.get(2).getCardCount() ==5){
                        gameView.deleteCardViewGrid(2);
                        addPenality(cardStacks.get(2).getSumPenalty());
                    }
                    if(cardStacks.get(2).getTopValue() >= card.getValue() && cardStacks.get(2).getCardCount() !=5){
                        gameView.deleteCardViewGrid(2);
                        addPenality(cardStacks.get(2).getSumPenalty());
                    }
                    cardStacks.get(2).addMayTakeIfBelowOr6th(card);
                    break;
                case 3:
                    if(cardStacks.get(3).getCardCount() ==5){
                        gameView.deleteCardViewGrid(3);
                        addPenality(cardStacks.get(3).getSumPenalty());
                    }
                    if(cardStacks.get(3).getTopValue() >= card.getValue() && cardStacks.get(3).getCardCount() !=5){
                        gameView.deleteCardViewGrid(3);
                        addPenality(cardStacks.get(3).getSumPenalty());
                    }
                    cardStacks.get(3).addMayTakeIfBelowOr6th(card);
                    break;
            }


        }

    }

}
