package com.company;

import java.util.Random;

class Computer {
    private String choice;
    private String[] choices = {"Rock", "Paper", "Scissors"};

    void setChoice() {
        Random r = new Random();
        int randomNumber = r.nextInt(choices.length);
        this.choice = choices[randomNumber];
    }

    String getChoice() {
        return choice;
    }
}
