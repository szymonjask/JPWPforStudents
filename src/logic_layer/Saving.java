package logic_layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Saving {

    public static void makingFile(String arg) {
        File starting = new File(System.getProperty("user.dir"));
        try {
            File myObj = new File(starting,"\\saves\\"+arg+".csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void writeToFile(FlashcardPackage deck) {
        File starting = new File(System.getProperty("user.dir"));

        try {
            FileWriter myWriter = new FileWriter(starting+"\\saves\\"+deck.getName()+".csv");
            for (Flashcard card : deck.getFlashcards()) {
                myWriter.write(card.getWord()+","
                        +card.getTranslation()+","
                        +card.getCounter()+","
                        +card.getCorrect_answer()+","
                        +card.getWrong_answer()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBasic(FlashcardPackage deck) {
        File starting = new File(System.getProperty("user.dir"));

        try {
            FileWriter myWriter = new FileWriter(starting+"\\basicSets\\"+deck.getName()+".csv");
            for (Flashcard card : deck.getFlashcards()) {
                myWriter.write(card.getWord()+","
                        +card.getTranslation()+","
                        +card.getCounter()+","
                        +card.getCorrect_answer()+","
                        +card.getWrong_answer()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FlashcardPackage readFile(String deckName) {
        File starting = new File(System.getProperty("user.dir"));

        try {
            File myObj = new File(starting,"\\saves\\"+deckName+".csv");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Flashcard> flashcards = new ArrayList<Flashcard>();
            while(myReader.hasNextLine()){
                String[] records = myReader.nextLine().split(",");
                flashcards.add(new Flashcard(records[0], records[1], Integer.parseInt(records[2]), Integer.parseInt(records[3]), Integer.parseInt(records[4])));
            }
            return new FlashcardPackage(flashcards, deckName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static FlashcardPackage readBasic(String deckName) {
        File starting = new File(System.getProperty("user.dir"));

        try {
            File myObj = new File(starting,"\\basicSets\\"+deckName+".csv");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Flashcard> flashcards = new ArrayList<Flashcard>();
            //System.out.println(myReader.nextLine());
            while(myReader.hasNextLine()){
                String[] records = myReader.nextLine().split(",");
                flashcards.add(new Flashcard(records[0], records[1], Integer.parseInt(records[2]), Integer.parseInt(records[3]), Integer.parseInt(records[4])));
            }
            return new FlashcardPackage(flashcards, deckName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public static ArrayList<FlashcardPackage> readAll(String folderName) {
        ArrayList<FlashcardPackage> sets = new ArrayList<FlashcardPackage>();
        try {
            File starting = new File(System.getProperty("user.dir"));
            File folder = new File(starting, folderName);
            for(int i = 0; i < Objects.requireNonNull(folder.list()).length; i++){
                String name = Objects.requireNonNull(folder.list())[i].split("\\.")[0];
                if(folderName.equals("saves")) {
                    FlashcardPackage pack = Saving.readFile(name);
                    sets.add(pack);
                } else if (folderName.equals("basicSets")) {
                    FlashcardPackage pack = Saving.readBasic(name);
                    sets.add(pack);
                }
            }
            return sets;
        }catch(Exception e){
            System.out.println("Blad przy wczytywaniu gotowych zestawow");
            return null;
        }
    }


}
