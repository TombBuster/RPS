package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");
        boolean isReplaying = true;
	    while (isReplaying) {
            // Player choice:

            System.out.println("Please choose an option: ");
            String playerChoice = "null";
            boolean isNotValidChoice = true;
            String[] choices = {"Rock", "Paper", "Scissors"};
            int choicesLength = choices.length;
        while (isNotValidChoice) {
            playerChoice = scanner.nextLine();
            for (String choice: choices) {
                if (playerChoice.equals(choice)) {
                    isNotValidChoice = false;
                }
            }
        }
//            Random rPlayer = new Random();
//            int randomPlayerNumber = rPlayer.nextInt(choicesLength);
//            playerChoice = choices[randomPlayerNumber];
            System.out.println("Your choice was: " + playerChoice);

            // Computer choice:
            Random r = new Random();
            int randomNumber = r.nextInt(choicesLength);
            String compChoice = choices[randomNumber];
            System.out.println("The computer chose: " + compChoice);

            // Choice logic:
            int playerIndex = Arrays.asList(choices).indexOf(playerChoice);
            int compIndex = Arrays.asList(choices).indexOf(compChoice);

            int result = (playerIndex - compIndex) % choicesLength;
            if (result < 0) {
                result += choicesLength;
            }

            if (result == 1) {
                System.out.println("You won!");
            } else if (result == 0) {
                System.out.println("You drew!");
            } else {
                System.out.println("You lost!");
            }

            // Replay:
            System.out.println("Play again? (y/n)");
            String replay = "null";
            while (true) {
                replay = scanner.nextLine();
                if (replay.equals("y")) {
                    isReplaying = true;
                    break;
                } else if ( replay.equals("n")) {
                    isReplaying = false;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter either y or n.");
                }
            }
        }
    }
}
