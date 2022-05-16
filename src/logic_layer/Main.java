package logic_layer;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flashcard card1 = new Flashcard("woda", "water");
        Flashcard card2 = new Flashcard("piwo", "beer");

        ArrayList<Flashcard> deck1 = new ArrayList<Flashcard>();
        deck1.add(card1);
        deck1.add(card2);

        FlashcardPackage flashcardPackage = new FlashcardPackage(deck1, "first deck");
        Saving.writeToFile(flashcardPackage);

        FlashcardPackage openSave = Saving.readFile("first deck");
        System.out.println(openSave.getFlashcards().get(1).getWord());
        openSave.deleteFlashcard("woda", "water");

        openSave.addFlashcard("chleb", "bread");
        Saving.writeToFile(openSave);

        System.out.println("___________________________________________________");
        File starting = new File(System.getProperty("user.dir"));
        System.out.println(starting);
        File myObj = new File(starting,"\\saves\\");

        File directory=new File(".");
        int fileCount=directory.list().length;
        System.out.println(directory);
        System.out.println("File Count:"+fileCount);
        System.out.println(directory.list()[0]);

        for (int i= 0; i<directory.list().length;i++){
            System.out.println(directory.list()[i]);
        }

        FlashcardPackage openReady = Saving.readBasic("Food");
        System.out.println(openReady.getFlashcards().get(2).getWord());


    }

}
