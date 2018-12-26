

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Dictionary {
    private String[] readOutFiles;
    private String wordsToReadOut;
    private String drawn;
    private int length = 0;
    private int numberInList;
    private int maxStringLength;
    private ArrayList<String> words = new ArrayList<>();

    void readOutFile() {

        File fileData = new File("bullCow.txt");
        this.wordsToReadOut = "";
        try {
            Scanner scanner = new Scanner(fileData);
            while (scanner.hasNextLine()) {
                wordsToReadOut += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

    }

    void addElement() {
        this.readOutFiles = wordsToReadOut.split(" ");
        for (int x = 0; x < readOutFiles.length; x++) {
            words.add(readOutFiles[x]);

        }

    }



    String draw() {
        do {
            Random random = new Random();
            numberInList = random.nextInt(words.size());
            this.drawn = words.get(numberInList);
        } while (drawn.length() != length && length != 0 && length != 1 && length != 2 && length <= maxStringLength);

        return words.get(numberInList);
    }

    int drawnLength() {

        return drawn.length();
    }

    void setPasswordLength(int length) {
        this.length = length;
    }

     int maxLength() {
        for (int x = 0; x < readOutFiles.length; x++) {
            if (readOutFiles[x].length() > maxStringLength) {
                this.maxStringLength = readOutFiles[x].length();
            }
        }
        return maxStringLength;
    }
}
