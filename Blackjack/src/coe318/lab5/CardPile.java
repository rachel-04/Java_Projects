package coe318.lab5;

import java.util.ArrayList;
import java.util.Collections;

public class CardPile {
    private ArrayList<Card> cards;

    public CardPile() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.size() == 0) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public int getTotalScore() {
        int total = 0;
        for (Card c : cards) {
            total += c.getScore();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CardPile deck = new CardPile();
        deck.add(new Card(1, Card.SPADES));
        deck.add(new Card(13, Card.HEARTS));
        deck.add(new Card(10, Card.CLUBS));

        System.out.println("Before shuffle:");
        System.out.println(deck);

        deck.shuffle();
        System.out.println("After shuffle:");
        System.out.println(deck);

        Card drawn = deck.draw();
        System.out.println("Drew card: " + drawn);
        System.out.println("Remaining pile:");
        System.out.println(deck);

        System.out.println("Total score: " + deck.getTotalScore());
    }
}
