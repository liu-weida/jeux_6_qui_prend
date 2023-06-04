package com.example.jeux_6_qui_prend.characters;

import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.CardSet;

import java.util.ArrayList;

public abstract class Character {
    protected String name;
    protected CardSet hand;
    protected int score;

    protected boolean isAi;

    protected boolean canChooseCard;
    protected boolean canPLayCard;

    protected int sumPenality;

    protected ArrayList<Card> tbCards;

    public String getName(){
        return this.name;
    }
    public CardSet getHand(){
        return this.hand;
    }

    public int getScore(){
        return this.score;
    }
    public void addToScore(int points) {
        score += points;
    }
    public void removeCard(Card card) {
        hand.removeCard(card);
    }
    public void setHand(CardSet hand){
        this.hand = hand;
    }

    public Boolean getCanChooseCard(){
        return this.canChooseCard;
    }

    public boolean getCanPlayCard(){
        return this.canPLayCard;
    }
    public void setChooseCard(Boolean value){
        this.canChooseCard = value;
    }

    public void setCanPLayCard(Boolean value){
        this.canPLayCard = value;
    }
    public boolean getAi(){
        return isAi;
    }

    public int getPenality(){
       return sumPenality;
    }

    public void addPenality(int value){
        sumPenality += value;
    }

}
