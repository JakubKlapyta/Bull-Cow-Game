package com.company;



import java.util.Scanner;

public class BullCowControl {
    public static void main(String[] args) {

        String word = "";
        int choose = 0;
        Dictionary dictionary = new Dictionary();
        BullCow bullCow = new BullCow();
        dictionary.readOutFile();
        dictionary.addElement();
        dictionary.maxLength();
        do {
            System.out.println("MENU");
            System.out.println();
            System.out.println("NEW GAME - 1");
            System.out.println("RULES - 2");
            System.out.println("CHANGE NUMBER OF ATTEMPTS(BASE 10) - 3");
            System.out.println("CHANGE WORD LENGTH - 4");
            System.out.println("QUIT - 5");

            Scanner menu = new Scanner(System.in);
            choose = menu.nextInt();

            if (choose == 1) {
                String draw = dictionary.draw();
                System.out.println("START");
                System.out.println();
                System.out.println("NUMBER OF LETTTERS IN YOUR WORD: " + dictionary.drawnLength());

//
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                System.out.println("GIVE A: " + dictionary.drawnLength() + " LETTER WORD");
                for (int x = 1; x <= bullCow.getNumberOfAttempts(); x++) {
                    System.out.println();
                    System.out.println("ATTEMPT NUMBER: " + x);
                    word = scanner.nextLine();
                    if (word.length() != dictionary.drawnLength() || !bullCow.isIsogram(word)) {
                        System.out.println("WRONG LETTER LENGTH OF TYPED WORD");

                    } else {
                        System.out.println("BULL: " + bullCow.bull(draw, word) + " COW: " + bullCow.cow(draw, word));
                        if ((bullCow.bull(draw, word) == dictionary.drawnLength())) {
                            System.out.println("VICTORY");
                            break;
                        }
                    }
                }
                if (!(dictionary.drawnLength() == word.length()) || bullCow.bull(draw, word) != dictionary.drawnLength()) {
                    System.out.println();
                    System.out.println("LOST - YOU RAN OUT OF ATTEMPTS");
                    System.out.println();
                    System.out.println();
                }
            } else if (choose == 2) {

                System.out.println(bullCow.gameRules());

            } else if (choose == 3) {

                Scanner attemptsNumber = new Scanner(System.in);

                System.out.println("CHOOSE NEW NUMBER OF ATTEMPTS");
                int chooseNumber = attemptsNumber.nextInt();
                bullCow.setNumberOfAttempts(chooseNumber);

            } else if (choose == 4) {
                Scanner passwordLength = new Scanner(System.in);
                System.out.println("CHOOSE NEW PASSWORD LENGTH");
                System.out.println("MIN 3 LETTERS");
                System.out.println("MAX " + dictionary.maxLength() + " LETTERS");
                int choosePasswordLength = passwordLength.nextInt();
                if (choosePasswordLength > dictionary.maxLength() || choosePasswordLength < 3) {
                    System.out.println("NEW LENGTH CHOSE WRONGLY ");
                }else{
                    System.out.println("PASSWORD LENGTH HAS BENN CHANGED TO: " +choosePasswordLength +" TO RETURN DO DEFAULT IN CHANGE WORD LENGTH MENU TYPE 0");
                }
                dictionary.setPasswordLength(choosePasswordLength);
            } else if (choose == 5) {
                bullCow.quit();
            } else {
                System.out.println("nie ma takiej opcji w menu");
            }
        } while (choose != 5);
    }

}


