package logic_layer;

public class Flashcard {

    private String word;
    private String translation;
    private int correct_answer;
    private int wrong_answer;
    private int medium_answer;
    private int all_answer;
    private int counter;

    public Flashcard(String word, String translation, int counter, int correct_answer, int wrong_answer) {
        this.word = word;
        this.translation = translation;
        this.correct_answer = correct_answer;
        this.wrong_answer = wrong_answer;
        this.counter = counter;
        this.all_answer = correct_answer + wrong_answer;
    }

    public Flashcard(String word, String translation) {
        this.word = word;
        this.translation = translation;
        correct_answer = 0;
        wrong_answer = 0;
        this.counter = 1;
    }

    public String toString(){
        return word;
    }

    //setters and getters

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
        setAll_answer();
        setMedium_answer();
    }

    public int getWrong_answer() {
        return wrong_answer;
    }

    public void setWrong_answer(int wrong_answer) {
        this.wrong_answer = wrong_answer;
        setAll_answer();
        setMedium_answer();
    }

    public int getMedium_answer() {
        return medium_answer;
    }

    public void setMedium_answer() {
        if (this.all_answer == 0) {
            this.medium_answer = 0;
        } else {
            this.medium_answer = this.correct_answer/this.all_answer;
        }
    }

    public int getAll_answer() {
        return this.correct_answer + this.wrong_answer;
    }

    public void setAll_answer() {
        this.all_answer = this.correct_answer + this.wrong_answer;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
