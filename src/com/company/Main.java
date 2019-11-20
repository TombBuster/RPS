package com.company;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Game game = new Game();
        game.asciiArt();
        Player player = new Player();
        player.setBalance();
        int initialBalance = player.getBalance();
        int balance;
        boolean isReplaying = true;
        while (isReplaying) {
            //Player bet:
            player.setBet();

            // Player choice:
            player.setChoice();
            String playerChoice = player.getChoice();
            System.out.println("Your choice was: " + playerChoice);

            // Computer choice:
            Computer computer = new Computer();
            computer.setChoice();
            String compChoice = computer.getChoice();
            System.out.println("The computer chose: " + compChoice);

            // Choice logic, string position in array is important here:
            int playerIndex = Arrays.asList(choices).indexOf(playerChoice);
            int compIndex = Arrays.asList(choices).indexOf(compChoice);
            int result = (playerIndex - compIndex) % choices.length;

            // Java % returns remainder rather than modulo, so need to correct negative numbers:
            if (result < 0) {
                result += choices.length;
            }

            // determines whether player won and resolves bet accordingly:

            int bet = player.getBet();
            int money = game.determineWin(result, bet);
            player.addToBalance(money);
            balance = player.getBalance();

            // Replay:
            System.out.println("Your balance is: " + balance);
            if (balance == 0) {
                System.out.println("You have no more money left to bet! Credit betting is not permitted here.");
                isReplaying = false;
            } else {
                isReplaying = game.isReplay();
            }
        }
        player.finalBalance(initialBalance);
    }
}
