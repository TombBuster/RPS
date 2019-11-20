package com.company;

import java.util.Scanner;

class Game {

    int determineWin(int result, int bet) {

        if (result == 1) {
            System.out.println("You won!");
            return bet;
        } else if (result == 0) {
            System.out.println("You drew!");
            return 0;
        } else {
            System.out.println("You lost!");
            return -bet;
        }
    }

    boolean isReplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play again? (y/n)");
        String replay;
        while (true) {
            replay = scanner.nextLine();
            if (replay.equals("y")) {
                return true;
            } else if (replay.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter either y or n.");
            }
        }
    }

}
