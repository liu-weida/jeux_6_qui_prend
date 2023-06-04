package com.example.jeux_6_qui_prend.model;

import com.example.jeux_6_qui_prend.characters.Character;
import javafx.scene.control.Button;

import java.lang.reflect.Array;
import java.util.*;

import static com.example.jeux_6_qui_prend.model.Cards.cards;

public class GameModel {
    public GameModel(){

    }

    /**
     * Supprime une carte spécifique de la main d'un personnage.
     *
     * @param character Le personnage dont on souhaite supprimer la carte.
     * @param card La carte à supprimer de la main du personnage.
     */
    public void removeCharacterCard(Character character,Card card){
          character.getHand().removeCard(card);
    }

    /**
     * Détermine l'ordre de jeu des personnages en fonction des cartes de personnage et de la liste des personnages.
     * Trie les cartes par ordre croissant de valeur en utilisant un comparateur personnalisé.
     * Parcourt les cartes triées et ajoute les personnages correspondants à l'ordre de jeu.
     *
     * @param characterCard La liste des cartes de personnage.
     * @param characterList La liste des personnages.
     * @return Une liste ordonnée des personnages selon l'ordre de jeu.
     */
    public ArrayList<Character> playOrder(ArrayList<Card> characterCard, ArrayList<Character> characterList){
        ArrayList<Character> characterOrder = new ArrayList<>();
        // Trie les cartes par ordre croissant de valeur en utilisant un comparateur personnalisé
          ArrayList<Card> sortedCards = sortCard(characterCard);
          for(Card card: sortedCards){
              for(Character character: characterList){
                  if(isCardPresent(card,character.getHand().remains())){
                      characterOrder.add(character);
                  }
              }
          }
        return characterOrder;
    }

    /**
     * Détermine l'ordre des cartes en fonction de leur valeur.
     * Trie les cartes dans l'ordre croissant de leur valeur en utilisant un comparateur personnalisé.
     *
     * @param cards La liste des cartes à trier.
     * @return Une liste de cartes triées dans l'ordre croissant de leur valeur.
     */
    public ArrayList<Card> cardOrder(ArrayList<Card> cards){
        return sortCard(cards);
    }

    /**
     * Vérifie si une carte est présente dans une collection de cartes.
     *
     * @param card La carte à rechercher.
     * @param collection La collection de cartes dans laquelle effectuer la recherche.
     * @return true si la carte est présente dans la collection, sinon false.
     */
    public static boolean isCardPresent(Card card, Collection<Card> collection) {
        return collection.contains(card);
    }

    /**
     * Trie une liste de cartes dans l'ordre croissant de leur valeur.
     *
     * @param sortedCards La liste de cartes à trier.
     * @return Une liste de cartes triées dans l'ordre croissant de leur valeur.
     */
    public ArrayList<Card> sortCard(ArrayList<Card> sortedCards){
        Collections.sort(sortedCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                // Compare les valeurs des cartes pour déterminer leur ordre
                return Integer.compare(card1.getValue(), card2.getValue());
            }
        });
        return sortedCards;
    }

    /**
     * Définit les cartes initiales pour le premier tas de cartes en évitant les cartes déjà présentes dans les mains des personnages.
     *
     * @param characters La liste des personnages.
     * @return Une liste de cartes représentant les cartes initiales pour le premier tas de cartes.
     */
    public ArrayList<Card> setFirstPileCards(ArrayList<Character> characters){
        Random random = new Random();
        ArrayList<Card> firstPileCards = new ArrayList<>();
        boolean canPutInPile = false;
        while(firstPileCards.size() <=4){
            Card card = cards.get(random.nextInt(cards.size()));
            for(Character character: characters){
               if(isCardPresent(card,character.getHand().remains()) ||  firstPileCards.contains(card)){
                   canPutInPile = false;
               }
               else{
                   canPutInPile = true;
               }
            }
            if(canPutInPile){
                firstPileCards.add(card);
            }
        }
        return firstPileCards;
    }

    /**
     * Vide tous les tas de cartes en supprimant toutes les cartes qu'ils contiennent.
     *
     * @param cardStacks La liste des tas de cartes à vider.
     */
    public void clearAllCardStack(ArrayList<CardStack> cardStacks){
        for(CardStack cardStack: cardStacks){
            cardStack.getCards().clear();
        }
    }


}
