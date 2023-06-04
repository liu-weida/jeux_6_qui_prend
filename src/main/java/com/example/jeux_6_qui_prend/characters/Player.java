package com.example.jeux_6_qui_prend.characters;

import com.example.jeux_6_qui_prend.model.CardSet;

import java.util.ArrayList;

public class Player extends Character{
    public Player(){
        this.name = "Joueur Humain";
        this.canPLayCard = false;
        this.canChooseCard = true;
        this.isAi = false;
        this.tbCards = new ArrayList<>();
        this.sumPenality = 0;
        this.name = "Joueur Humain";
    }


}
