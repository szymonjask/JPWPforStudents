package logic_layer;

import java.util.ArrayList;

public class Stats {

    private ArrayList<Flashcard> allFlashcards;
    private FlashcardPackage saves;
    private FlashcardPackage basic;


    public Stats() {
        allFlashcards = new ArrayList<Flashcard>();
        ArrayList<FlashcardPackage> own = Saving.readAll("saves");
        ArrayList<FlashcardPackage> basic = Saving.readAll("basicSets");
        if (own != null) {
            for (FlashcardPackage flashcardPackage : own) {
                allFlashcards.addAll(flashcardPackage.getFlashcards());
            }
        }
        if (basic != null) {
            for (FlashcardPackage flashcardPackage : basic) {
                allFlashcards.addAll(flashcardPackage.getFlashcards());
            }
        }
    }

    public int getAllCorrectNo() {
        int no = 0;
        for(Flashcard flashcard:allFlashcards){
            no += flashcard.getCorrect_answer();
        }
        return no;
    }

    public int getAllWrongNo() {
        int no = 0;
        for(Flashcard flashcard:allFlashcards){
            no += flashcard.getWrong_answer();
        }
        return no;
    }

    public int getAllNo() {
        return getAllCorrectNo() + getAllWrongNo();
    }

    public int getAllCounterNo() {
        int no = 0;
        for(Flashcard flashcard:allFlashcards) {
            no += flashcard.getCounter() - 1;
        }
        return no;
    }




    public void setAllFlashcards(ArrayList<Flashcard> allFlashcards) {
        this.allFlashcards = allFlashcards;
    }
}
