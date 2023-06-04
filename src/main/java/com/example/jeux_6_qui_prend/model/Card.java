package com.example.jeux_6_qui_prend.model;

public class Card implements Comparable<Card>{
    public final int value;
    public final int penalty;

    public Card(int value, int penalty) {
        this.value = value;
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Card-" + value;
    }

    public int getValue(){
        return this.value;
    }

    public int getPenalty(){
        return this.value;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.value, other.value);
    }
}
