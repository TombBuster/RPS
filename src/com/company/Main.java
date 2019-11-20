package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("How much money do you want to start with?");
        int balance = 0;
        boolean isValidBalance = false;
        while (!isValidBalance) {
        try {
            balance = Integer.parseInt(scanner.nextLine());
        } catch(Exception e) {
            System.out.println("Invalid type. Please enter a number:");
        }
        if (balance <= 0) {
            System.out.println("Please enter a positive value:");
        } else {
            isValidBalance = true;
        }
        }
        int initialBalance = balance;
        boolean isReplaying = true;
        while (isReplaying) {
            //Player bet:
            int bet = 0;
            boolean isValidBet = false;
            while (!isValidBet) {
                try {
                    System.out.println("Please enter an amount to bet: ");
                    bet = Integer.parseInt(scanner.nextLine());
                } catch(Exception e) {
                    System.out.println("Invalid type. Please enter a number:");
                }
                if (bet > balance) {
                    System.out.println("You don't have enough money for that bet. Please enter a lower amount:");
                } else if (bet <= 0) {
                    System.out.println("Please enter a positive amount: ");
                } else {
                    isValidBet = true;
                }
            }

            // Player choice:

            String playerChoice = "Random";
            boolean isValidChoice = false;
            String[] choices = {"Rock", "Paper", "Scissors", "Random"};
            int choicesLength = choices.length;
            while (!isValidChoice) {
                System.out.println("Please choose an option: ");
                playerChoice = scanner.nextLine();
                // Case insensitive
                playerChoice = playerChoice.substring(0, 1).toUpperCase() + playerChoice.substring(1).toLowerCase();
                for (String choice : choices) {
                    if (playerChoice.equals(choice)) {
                        isValidChoice = true;
                        break;
                    }
                }
            }

            if (playerChoice.equals("Random")) {
                Random rPlayer = new Random();
                int randomPlayerNumber = rPlayer.nextInt(choicesLength);
                playerChoice = choices[randomPlayerNumber];
            }
            System.out.println("Your choice was: " + playerChoice);

            // Computer choice:
            Random r = new Random();
            int randomNumber = r.nextInt(choicesLength);
            String compChoice = choices[randomNumber];
            System.out.println("The computer chose: " + compChoice);

            // Choice logic, string position in array is important here:
            int playerIndex = Arrays.asList(choices).indexOf(playerChoice);
            int compIndex = Arrays.asList(choices).indexOf(compChoice);
            int result = (playerIndex - compIndex) % choicesLength;

            // Java % returns remainder rather than modulo, so need to correct negative numbers:
            if (result < 0) {
                result += choicesLength;
            }

            if (result == 1) {
                System.out.println("You won!");
                balance += bet;
            } else if (result == 0) {
                System.out.println("You drew!");
            } else {
                System.out.println("You lost!");
                balance -= bet;
            }

            // Replay:
            System.out.println("Your balance is: " + balance);
            if (balance == 0) {
                System.out.println("You have no more money left to bet! Credit betting is not permitted here.");
                isReplaying = false;
            } else {
                System.out.println("Play again? (y/n)");
                String replay;
                while (true) {
                    replay = scanner.nextLine();
                    if (replay.equals("y")) {
                        break;
                    } else if (replay.equals("n")) {
                        isReplaying = false;
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter either y or n.");
                    }
                }
            }
        }
        int balanceDifference = balance - initialBalance;
        if (balanceDifference > 0) {
            System.out.println("You made a profit of £" + balanceDifference + "!");
        } else if (balanceDifference == 0) {
            System.out.println("You broke even!");
        } else {
            System.out.println("You lost £" + Math.abs(balanceDifference) + ".");
        }
    }
}
