package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class BullCow {
    private int numberOfAttempts = 10;

    public static boolean isIsogram(String word) {
        String[] wordArray = word.split("");
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordArray));
        return wordArray.length == wordSet.size();
    }

    public static int bull(String drawn, String writeIn) {
        int bull = 0;
        String[] drawnArray = drawn.split("");
        String[] writeInArray = writeIn.split("");
        for (int y = 0; y < drawnArray.length; y++) {
            if (drawnArray[y].equals(writeInArray[y])) {
                bull++;
            }
        }
        return bull;
    }

    public static int cow(String drawn, String writeIn) {
        int cow = 0;
        String[] drawnArray = drawn.split("");
        String[] writeInArray = writeIn.split("");
        for (int y = 0; y < drawnArray.length; y++) {
            for (int x = 0; x < drawnArray.length; x++)
                if (drawnArray[y].equals(writeInArray[x])) {
                    cow++;
                }
        }
        return cow - bull(drawn, writeIn);
    }

    public String gameRules() {
       return "A person (Host) thinks of any isogram word, and gives out the number of letters in the word.\n" +
                "\n" +
                "Other players (Guessers) try to figure that word by guessing isogram words containing the same number of letters.\n" +
                "\n" +
                "Host responds with the number of Cows & Bulls for each guessed word. As with the digit version, \"Cow\" means a letter in the wrong position, while \"Bull\" means a letter in the right position.\n" +
                "\n" +
                "For example, if the secret word is HEAT, a guess of COIN would result in \"0 Bulls, 0 Cows\" (all of the guessed letters are wrong);\na guess of EATS would result in \"0 Bulls, 3 Cows\" (since E, A, T are all present, but not in the guessed positions),\nand a guess of TEAL would result in \"2 Bulls, 1 Cow\" (since E and A are in the right positions, while T is in the wrong position).\nThe game would continue until someone scores \"4 Bulls\" for guessing HEAT exactly.\n";
        }

    public static void quit() {
        System.out.println("THANKS FOR GAMING");
    }


    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

}
