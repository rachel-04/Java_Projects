package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner input;

    public SimpleUI(BlackjackGame game) {
        this.game = game;
        this.input = new Scanner(System.in);
    }

    @Override
    public void display() {
        System.out.println("House holds:");
        for (int i = 1; i < game.getHouseCards().size(); i++) {
            System.out.println(game.getHouseCards().get(i));
        }
        System.out.println("?");

        System.out.println("\nYou hold:");
        for (Card c : game.getYourCards()) {
            System.out.println(c);
        }
    }

    @Override
    public boolean hitMe() {
        System.out.print("Another card? (y/n): ");
        String response = input.nextLine().trim().toLowerCase();
        return response.equals("y");
    }

    @Override
    public void gameOver() {
        System.out.println("\nGame over\n");

        System.out.println("House holds:");
        for (Card c : game.getHouseCards()) {
            System.out.println(c);
        }

        System.out.println("\nYou hold:");
        for (Card c : game.getYourCards()) {
            System.out.println(c);
        }

        System.out.println("\nYour score: " + game.score(game.getYourCards()));
        System.out.println("House score: " + game.score(game.getHouseCards()));

        if (game.score(game.getYourCards()) > 21) {
            System.out.println("You went over 21. The House wins!");
        } else if (game.score(game.getHouseCards()) > 21) {
            System.out.println("House went over 21. You win!");
        } else if (game.score(game.getYourCards()) > game.score(game.getHouseCards())) {
            System.out.println("You win!");
        } else {
            System.out.println("The House wins!");
        }
    }
}
