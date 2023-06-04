package com.example.jeux_6_qui_prend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardStack {
    private final List<Card> cards = new ArrayList<>(5);

    private int sumPenalty;
    private int topValue;

    //---------------------------------------------------------------------------------------------

    public CardStack(Card firstCard) {
        Objects.requireNonNull(firstCard);
        resetWithTopCard(firstCard);
    }

    //---------------------------------------------------------------------------------------------

    public int getCardCount() {
        return cards.size();
    }

    public List<Card> addMayTakeIfBelowOr6th(Card c) {
        Objects.requireNonNull(c);
        List<Card> res;
        if (c.value < topValue) {
            res = new ArrayList<>(cards);
            this.cards.clear();
            resetWithTopCard(c);
        } else {
            if (cards.size() == 5) {
                res = new ArrayList<>(cards);
                this.cards.clear();
                resetWithTopCard(c);
            } else {
                cards.add(c);
                this.sumPenalty += c.penalty;
                this.topValue = c.value;
                res = null;
            }
        }
        return res;
    }

    protected void resetWithTopCard(Card card) {
        this.cards.add(card);
        this.sumPenalty = card.penalty;
        this.topValue = card.value;
    }

    public int getTopValue(){
        return this.topValue;
    }

    public int getSumPenalty(){
        return this.sumPenalty;
    }
    public Card getCard(int index) {
        if (index < 0 || index >= cards.size()) {
            throw new IndexOutOfBoundsException(); // Or return null, depending on your needs
        }
        return cards.get(index);
    }

    public List<Card> getCards(){
        return this.cards;
    }
}
