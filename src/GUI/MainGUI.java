package GUI;

import logic_layer.Flashcard;
import logic_layer.FlashcardPackage;
import logic_layer.Lotto;
import logic_layer.Saving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class MainGUI {

    private JPanel panel1;

    private JButton myDecksButton;
    private JButton newFlashcardsButton;
    private JButton statisticsButton;
    private JButton decksButton;
    private JButton findButton;
    private JButton startButton;
    private JLabel currentDeckLabel;
    private JPanel test;
    private JPanel easyMode;
    private JButton acceptButton;
    private JPanel hardMode;
    private JTextField hardTranslationField;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JLabel easyWordLabel;
    private JLabel hardWordLabel;
    private JLabel isCorrectLabel;
    private JLabel wordField;

    private ArrayList<FlashcardPackage> basicSets;
    private FlashcardPackage currentPackage;
    private ArrayList<FlashcardPackage> ownSets;
    private final String basicType = "Basic";
    private final String ownType = "Own";

    private Flashcard chosenCard;


    public MainGUI() {

        // Wylaczenie obu trybow na poczatku
        easyMode.setVisible(false);
        hardMode.setVisible(false);

        // Do tej zmiennej wczytywane sa podstawowe zestawy, ktore zostana wczytane do aplikacji
        // Nie pomylić sobie nazw
        basicSets = Saving.readAll("basicSets");
        ownSets = Saving.readAll("saves");

        // Obecny zestaw do wyswietlania
        currentPackage = new FlashcardPackage();

        myDecksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new MyDecksGUI(ownSets, currentPackage, startButton, easyMode, hardMode,
                        isCorrectLabel);
                f.setTitle("Moje fiszki");
                f.pack();
                f.setVisible(true);
            }
        });

        decksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new SetsGUI(basicSets, currentPackage, startButton, easyMode, hardMode,
                        isCorrectLabel);
                f.setTitle("Zestawy");
                f.pack();
                f.setVisible(true);
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new findGUI();
                f.setTitle("Szukanie");
                f.pack();
                f.setVisible(true);
            }
        });
        newFlashcardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NewFlashcardsGUI();
                f.setTitle("Tworzenie nowych zestawów");
                f.pack();
                f.setVisible(true);
            }
        });

        statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new StatisticsGUI(currentPackage);
                f.setTitle("Statystyki");
                f.pack();
                f.setVisible(true);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                boolean isCorrect = false;
                int poss = currentPackage.getFlashcards().indexOf(chosenCard);
                for(int j = 0; j < currentPackage.getFlashcards().size(); j++){
                    if (currentPackage.getFlashcards().get(j).getTranslation().equals(hardTranslationField.getText())) {
                        if (currentPackage.getFlashcards().get(j).getWord().equals(hardWordLabel.getText())) {
                            poss = j;
                            isCorrect = true;
                            break;
                        }
                    }
                }
                if(isCorrect){
                    isCorrectLabel.setText("Dobrze!");
                    isCorrectLabel.setForeground(Color.GREEN);
                }else{
                    isCorrectLabel.setText("Źle!");
                    isCorrectLabel.setForeground(Color.RED);
                }
                lotto.answer(currentPackage.getFlashcards().get(poss), isCorrect);
                refresh();
            }
        });


        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                boolean isCorrect = false;
                int poss = currentPackage.getFlashcards().indexOf(chosenCard);
                for(int j = 0; j < currentPackage.getFlashcards().size(); j++){
                    if (currentPackage.getFlashcards().get(j).getTranslation().equals(buttonA.getText())) {
                        if (currentPackage.getFlashcards().get(j).getWord().equals(easyWordLabel.getText())) {
                            poss = j;
                            isCorrect = true;
                            break;
                        }
                    }
                }
                if(isCorrect){
                    isCorrectLabel.setText("Dobrze!");
                    isCorrectLabel.setForeground(Color.GREEN);
                }else{
                    isCorrectLabel.setText("Źle!");
                    isCorrectLabel.setForeground(Color.RED);
                }
                lotto.answer(currentPackage.getFlashcards().get(poss), isCorrect);
                refresh();
            }
        });
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                boolean isCorrect = false;
                int poss = currentPackage.getFlashcards().indexOf(chosenCard);
                for(int j = 0; j < currentPackage.getFlashcards().size(); j++){
                    if (currentPackage.getFlashcards().get(j).getTranslation().equals(buttonB.getText())) {
                        if (currentPackage.getFlashcards().get(j).getWord().equals(easyWordLabel.getText())) {
                            poss = j;
                            isCorrect = true;
                            break;
                        }
                    }
                }
                if(isCorrect){
                    isCorrectLabel.setText("Dobrze!");
                    isCorrectLabel.setForeground(Color.GREEN);
                }else{
                    isCorrectLabel.setText("Źle!");
                    isCorrectLabel.setForeground(Color.RED);
                }
                lotto.answer(currentPackage.getFlashcards().get(poss), isCorrect);
                refresh();
            }
        });
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                boolean isCorrect = false;
                int poss = currentPackage.getFlashcards().indexOf(chosenCard);
                for(int j = 0; j < currentPackage.getFlashcards().size(); j++){
                    if (currentPackage.getFlashcards().get(j).getTranslation().equals(buttonC.getText())) {
                        if (currentPackage.getFlashcards().get(j).getWord().equals(easyWordLabel.getText())) {
                            poss = j;
                            isCorrect = true;
                            break;
                        }
                    }
                }
                if(isCorrect){
                    isCorrectLabel.setText("Dobrze!");
                    isCorrectLabel.setForeground(Color.GREEN);
                }else{
                    isCorrectLabel.setText("Źle!");
                    isCorrectLabel.setForeground(Color.RED);
                }
                lotto.answer(currentPackage.getFlashcards().get(poss), isCorrect);
                refresh();
            }
        });
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                boolean isCorrect = false;
                int poss = currentPackage.getFlashcards().indexOf(chosenCard);
                for(int j = 0; j < currentPackage.getFlashcards().size(); j++){
                    if (currentPackage.getFlashcards().get(j).getTranslation().equals(buttonD.getText())) {
                        if (currentPackage.getFlashcards().get(j).getWord().equals(easyWordLabel.getText())) {
                            poss = j;
                            isCorrect = true;
                            break;
                        }
                    }
                }
                if(isCorrect){
                    isCorrectLabel.setText("Dobrze!");
                    isCorrectLabel.setForeground(Color.GREEN);
                }else{
                    isCorrectLabel.setText("Źle!");
                    isCorrectLabel.setForeground(Color.RED);
                }
                lotto.answer(currentPackage.getFlashcards().get(poss), isCorrect);
                refresh();
            }
        });
    }

    public void save() {
        if(currentDeckLabel.getText().split("-")[0].equals(basicType)) {
            Saving.writeBasic(currentPackage);
        } else if (currentDeckLabel.getText().split("-")[0].equals(ownType)) {
            Saving.writeToFile(currentPackage);
        }
    }

    public void refresh(){
        if(currentPackage.getFlashcards()==null) {
            Object[] options = {"OK",
                    "Anuluj"};
            JOptionPane.showOptionDialog(null,
                    "Najpierw wybierz zestaw", "Brak zestawu",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, null);
        }else{
            save();
            int chosenMode = (int)(Math.random() * (2));
            if (chosenMode == 0){
                hardMode.setVisible(false);
                easyMode.setVisible(true);
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                chosenCard = lotto.random();
                easyWordLabel.setText(chosenCard.getWord());
                int corrAns = (int)(Math.random() * (4)) + 1;
                for(;;){
                    if (corrAns == 1){
                        buttonA.setText(chosenCard.getTranslation());
                        break;
                    }
                    Flashcard wordA = lotto.random();
                    if (!wordA.getTranslation().equals(chosenCard.getTranslation())){
                        buttonA.setText(wordA.getTranslation());
                        break;
                    }
                }
                for(;;){
                    if (corrAns == 2){
                        buttonB.setText(chosenCard.getTranslation());
                        break;
                    }
                    Flashcard wordB = lotto.random();
                    if (!wordB.getTranslation().equals(chosenCard.getTranslation()) &&
                            !wordB.getTranslation().equals(buttonA.getText())){
                        buttonB.setText(wordB.getTranslation());
                        break;
                    }
                }
                for(;;){
                    if (corrAns == 3){
                        buttonC.setText(chosenCard.getTranslation());
                        break;
                    }
                    Flashcard wordC = lotto.random();
                    if (!wordC.getTranslation().equals(chosenCard.getTranslation()) &&
                            !wordC.getTranslation().equals(buttonA.getText()) &&
                            !wordC.getTranslation().equals(buttonB.getText())){
                        buttonC.setText(wordC.getTranslation());
                        break;
                    }
                }
                for(;;){
                    if (corrAns == 4){
                        buttonD.setText(chosenCard.getTranslation());
                        break;
                    }
                    Flashcard wordD = lotto.random();
                    if (!wordD.getTranslation().equals(chosenCard.getTranslation()) &&
                            !wordD.getTranslation().equals(buttonA.getText()) &&
                            !wordD.getTranslation().equals(buttonB.getText()) &&
                            !wordD.getTranslation().equals(buttonC.getText())){
                        buttonD.setText(wordD.getTranslation());
                        break;
                    }
                }
                startButton.setEnabled(false);
            }else{
                easyMode.setVisible(false);
                hardMode.setVisible(true);
                hardTranslationField.setText("");
                Lotto lotto = new Lotto(currentPackage.getFlashcards());
                chosenCard = lotto.random();
                hardWordLabel.setText(chosenCard.getWord());
                startButton.setEnabled(false);
            }
        }
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Aplikacja do fiszek");
        frame.setContentPane(new MainGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // Zad. 4 - (1/2) jedna linijka tutaj jest potrzebna, reszta nizej \/

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // Zad. 4 - (2/2)

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
