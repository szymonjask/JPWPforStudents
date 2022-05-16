package logic_layer;

import java.util.ArrayList;
import java.util.Collections;


public class Lotto {

    private ArrayList<Flashcard> flashcards;
    private ArrayList<Flashcard> flashcards_words;


    public Lotto(ArrayList<Flashcard> flashcards) {
        flashcards_words = new ArrayList<>();
        this.flashcards = flashcards;
        for (int i = 0; i < flashcards.size(); i++) {
            for (int j = 0; j < flashcards.get(i).getCounter(); j++) {
                this.flashcards_words.add(this.flashcards.get(i));
            }
        }
    }

    //function

    public Flashcard random() {
        int randomNum = (int)(Math.random() * (flashcards_words.size()));
        return flashcards_words.get(randomNum);
    }

    public void answer(Flashcard flashcard, boolean isCorrect) {
        if(isCorrect){

        } else {
            flashcards_words.add(flashcard);
            flashcard.setCounter(flashcard.getCounter() + 1);
            flashcard.setWrong_answer(flashcard.getWrong_answer() + 1);
        }
    }

    //getters and setters

    public ArrayList<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(ArrayList<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public ArrayList<Flashcard> getFlashcards_words() {
        return flashcards_words;
    }

    public void setFlashcards_words(ArrayList<Flashcard> flashcards_words) {
        this.flashcards_words = flashcards_words;
    }

}
