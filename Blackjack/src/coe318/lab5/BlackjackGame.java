package coe318.lab5;

import java.util.ArrayList;

public class BlackjackGame {
    private CardPile deck;
    private ArrayList<Card> houseCards;
    private ArrayList<Card> yourCards;
    private UserInterface ui;

    public BlackjackGame() {
        deck = new CardPile();
        houseCards = new ArrayList<>();
        yourCards = new ArrayList<>();
        ui = new SimpleUI(this);

        // Fill the deck with 52 cards
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(rank, suit));
            }
        }
        deck.shuffle();
    }

    public ArrayList<Card> getHouseCards() {
        return houseCards;
    }

    public ArrayList<Card> getYourCards() {
        return yourCards;
    }

    public int score(ArrayList<Card> hand) {
        int total = 0;
        for (Card c : hand) {
            total += c.getScore();
        }
        return total;
    }

    public void play() {
        // Deal 2 cards to each
        yourCards.add(deck.draw());
        yourCards.add(deck.draw());

        houseCards.add(deck.draw());
        houseCards.add(deck.draw());

        ui.display();

        while (ui.hitMe()) {
            yourCards.add(deck.draw());
            ui.display();
        }

        // House hits until score >= 17
        while (score(houseCards) < 17) {
            houseCards.add(deck.draw());
        }

        ui.gameOver();
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.play();
    }
}
