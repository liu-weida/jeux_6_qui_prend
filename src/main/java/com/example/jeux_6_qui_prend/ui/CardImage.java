package com.example.jeux_6_qui_prend.ui;

import com.example.jeux_6_qui_prend.model.Card;
import com.example.jeux_6_qui_prend.model.Cards;
import javafx.scene.image.Image;

import java.net.URL;

public class CardImage {
    private static final Image backsideImage = createBacksizeImage();

    private static final Image[] cardImages = createCardImages();

    //---------------------------------------------------------------------------------------------

    public static Image getBacksideImage() {
        return backsideImage;
    }

    public static Image getFrontCardImage(Card card) {
        return (card != null)? cardImages[card.value] : backsideImage;
    }

    /**
     * Crée et renvoie l'image du dos de la carte.
     *
     * @return L'image du dos de la carte.
     */
    private static Image createBacksizeImage() {
        String imgUrl = CardImage.class.getResource("/com/example/jeux_6_qui_prend/images/card/backside.png").toString();
        return new Image(imgUrl);
    }

    /**
     * Crée et renvoie un tableau d'images pour chaque valeur de carte possible.
     *
     * @return Un tableau d'images pour chaque valeur de carte possible.
     */
    private static Image[] createCardImages() {
        Image[] res = new Image[1+ Cards.MAX_CARD_VALUE];
        res[0] = null;
        for(int i = 1; i <= Cards.MAX_CARD_VALUE; i++) {
            String imgUrl = CardImage.class.getResource("/com/example/jeux_6_qui_prend/images/card/" +i+".png").toString();
            res[i] = new Image(imgUrl);
        }
        return res;
    }
}
