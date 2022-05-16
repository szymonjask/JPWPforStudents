package logic_layer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlashcardPackage {

    private ArrayList<Flashcard> flashcards;
    private String name;

    //Nawet tego nie uzywam
    public FlashcardPackage(ArrayList<Flashcard> flashcards, String name) {
        this.flashcards = flashcards;
        this.name = name;
    }

    public FlashcardPackage() {
        this.flashcards = null;
        this.name = null;
    }

    public void change(ArrayList<Flashcard> flashcards, String name){
        this.flashcards = flashcards;
        this.name = name;
    }

    public String toString(){
        return name;
    }

    //setters and getters

    public ArrayList<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(ArrayList<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //adding and removing from list

    public  void addFlashcard(String word, String translate) {
        this.flashcards.add(new Flashcard(word, translate));
    }

    public Flashcard findFlashcard(String word, String translate) {
        for (Flashcard flashcard : flashcards) {
            if (flashcard.getWord().equals(word) && flashcard.getTranslation().equals(translate)) {
                return flashcard;
            }
        }
        return null;
    }

    public void deleteFlashcard(String word, String translate) {
        Flashcard toRemove = this.findFlashcard(word, translate);
        if (toRemove != null) {
            this.flashcards.remove(toRemove);
        } else {
            System.out.println("This does not exist");
        }
    }
}
