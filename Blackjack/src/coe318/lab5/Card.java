/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab5;

public class Card {
    private int rank;  // 1 to 13 (1 = Ace, 11 = Jack, 12 = Queen, 13 = King)
    private int suit;  // 0 = Clubs, 1 = Diamonds, 2 = Hearts, 3 = Spades

    // Constants for suit names
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;

    // Constructor
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Returns the score value of the card for Blackjack
    public int getScore() {
        if (rank == 1) {
            return 1; // Ace
        } else if (rank >= 11 && rank <= 13) {
            return 10; // Jack, Queen, King
        } else {
            return rank; // Number cards
        }
    }

    // String representation like "Queen of Hearts"
    @Override
    public String toString() {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        return ranks[rank - 1] + " of " + suits[suit];
    }

    // Check if two cards are the same (same rank and suit)
    public boolean equals(Card c) {
        return this.rank == c.rank && this.suit == c.suit;
    }

    // Compare two cards: first by rank, then by suit
    public int compareTo(Card c) {
        if (this.rank != c.rank) {
            return this.rank - c.rank;
        } else {
            return this.suit - c.suit;
        }
    }

    // Test method
    public static void main(String[] args) {
        Card c1 = new Card(12, HEARTS); // Queen of Hearts
        Card c2 = new Card(1, SPADES);  // Ace of Spades
        Card c3 = new Card(12, HEARTS); // Another Queen of Hearts

        System.out.println(c1); // Should print "Queen of Hearts"
        System.out.println("Score of c1: " + c1.getScore()); // Should print 10
        System.out.println("c1 equals c3? " + c1.equals(c3)); // Should print true
        System.out.println("c1 compareTo c2: " + c1.compareTo(c2)); // Should be > 0
    }
}
