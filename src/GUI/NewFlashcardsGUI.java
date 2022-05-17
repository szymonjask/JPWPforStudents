package GUI;

import logic_layer.Flashcard;
import logic_layer.FlashcardPackage;
import logic_layer.Saving;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NewFlashcardsGUI extends JFrame {
    private JPanel panel1;
    private JTextField wordField;
    private JTextField translationField;
    private JButton addButton;
    private JButton createButton;
    private JButton cancelButton;
    private JTextField nameField;
    private JLabel numOfWordsLabel;

    private FlashcardPackage newDeck;
    ArrayList<Flashcard> wordsList = new ArrayList<>();

    public NewFlashcardsGUI() {
        setContentPane(panel1);
        //ArrayList<Flashcard> wordsList = new ArrayList<>();
        //newDeck = new FlashcardPackage(wordsList, "newDeck");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!wordField.getText().strip().isEmpty() && !translationField.getText().strip().isEmpty()) {
                    Flashcard newWord = new Flashcard(wordField.getText().strip(), translationField.getText().strip());
                    wordsList.add(newWord);
                    numOfWordsLabel.setText("Słów w zestawie: " + wordsList.size());
                    wordField.setText("");
                    translationField.setText("");
                    System.out.println("Słowo dodane");
                } else {
                    System.out.println("Uzupełnij wszystkie pola!");
                }
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wordsList.size() > 0 && !nameField.getText().strip().isEmpty()){
                    FlashcardPackage newDeck = new FlashcardPackage(wordsList, nameField.getText().strip());
                    Saving.writeToFile(newDeck);
                    nameField.setText("");
                    numOfWordsLabel.setText("Słów w zestawie: " + "0");
                    System.out.println("Zestaw stworzony");
                }else{
                    System.out.println("Brak nazwy albo słów w zestawie!");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
