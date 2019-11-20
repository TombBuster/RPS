package com.company;

import java.util.Random;
import java.util.Scanner;

class Player {

    private int balance;
    private int bet;
    private String choice;

    void setBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money do you want to start with?");
        int initialBalance = 0;
        boolean isValidBalance = false;
        while (!isValidBalance) {
            try {
                initialBalance = Integer.parseInt(scanner.nextLine());
            } catch(Exception e) {
                System.out.println("Invalid type. Please enter a number.");
                continue;
            }
            if (initialBalance <= 0) {
                System.out.println("Please enter a positive value.");
            } else {
                isValidBalance = true;
            }
        }
        this.balance = initialBalance;
    }

    void setBet() {
        Scanner scanner = new Scanner(System.in);
        int inputBet = 0;
        boolean isValidBet = false;
        while (!isValidBet) {
            try {
                System.out.println("Please enter an amount to bet: ");
                inputBet = Integer.parseInt(scanner.nextLine());
            } catch(Exception e) {
                System.out.println("Invalid type. Please enter a number.");
                continue;
            }
            if (inputBet > balance) {
                System.out.println("You don't have enough money for that bet. Please enter a lower amount.");
            } else if (inputBet <= 0) {
                System.out.println("Please enter a positive amount.");
            } else {
                isValidBet = true;
            }
        }
        this.bet = inputBet;
    }

    void setChoice() {
        Scanner scanner = new Scanner(System.in);
        String playerChoice = "Random";
        boolean isValidChoice = false;
        String[] choices = {"Rock", "R", "Paper", "P", "Scissors", "S", "Random", "Ran"};
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
            switch (playerChoice) {
                case "R":
                    playerChoice = "Rock";
                    break;
                case "P":
                    playerChoice = "Paper";
                    break;
                case "S":
                    playerChoice = "Scissors";
                    break;
                case "Ran":
                    playerChoice = "Random";
            }
        }

        if (playerChoice.equals("Random")) {
            Random rPlayer = new Random();
            int randomPlayerNumber = rPlayer.nextInt(choicesLength);
            playerChoice = choices[randomPlayerNumber];
        }

        this.choice = playerChoice;
    }

    void addToBalance(int money) {
        try {
            balance = Math.addExact(balance, money);
        } catch(Exception e) {
            System.out.println("Max money reached! Any extra money has been donated to a charity of our choosing." +
                    "Your generosity is much appreciated!");
            balance = 2147483647;
        }
    }

    void finalBalance(int initialBalance) {
        int balanceDifference = balance - initialBalance;
        if (balanceDifference > 0) {
            System.out.println("You made a profit of £" + balanceDifference + "!");
        } else if (balanceDifference == 0) {
            System.out.println("You broke even!");
        } else {
            System.out.println("You lost £" + Math.abs(balanceDifference) + ".");
        }
    }

    int getBalance() {
        return balance;
    }

    int getBet() {
        return bet;
    }

    String getChoice() {
        return choice;
    }

}
