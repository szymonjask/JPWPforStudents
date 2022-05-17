package GUI;

import logic_layer.Flashcard;
import logic_layer.FlashcardPackage;
import logic_layer.Saving;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class EditDeckGUI extends JFrame {
    private JComboBox comboBox1;
    private JButton deleteButton;
    private JTextField wordField;
    private JTextField translationField;
    private JButton updateButton;
    private JButton backButton;
    private JButton addButton;
    private JPanel panel1;
    private JLabel whatIsEditedLabel;

    private ArrayList<FlashcardPackage> saveSets;
    private FlashcardPackage editedDeck;

    public EditDeckGUI(FlashcardPackage deck) {
        setContentPane(panel1);
        String newName = deck.getName();
        System.out.println(deck.getFlashcards());
        editedDeck = deck;
        whatIsEditedLabel.setText("Edytowany zestaw: " + editedDeck.getName());
        for(int i = 0; i < editedDeck.getFlashcards().size(); i++){
            comboBox1.addItem(editedDeck.getFlashcards().get(i));
        }
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem() != null) {
                    Flashcard toDelete = (Flashcard) comboBox1.getSelectedItem();
                    comboBox1.removeItem(comboBox1.getSelectedItem());
                    editedDeck.deleteFlashcard(toDelete.getWord(), toDelete.getTranslation());
                    System.out.println(editedDeck.getFlashcards());
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!wordField.getText().strip().isEmpty() && !translationField.getText().strip().isEmpty()){
                    String word = wordField.getText().strip().toLowerCase();
                    String translation = translationField.getText().strip().toLowerCase();
                    editedDeck.addFlashcard(word, translation);
                    int deckSize = editedDeck.getFlashcards().size();
                    comboBox1.addItem(editedDeck.getFlashcards().get(deckSize - 1));
                    wordField.setText("");
                    translationField.setText("");
                }else{
                    System.out.println("Uzupełnij wszystkie pola");
                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saving.writeToFile(editedDeck);
                if(editedDeck.getFlashcards().size() == 0){
                    Saving.deleteFile(editedDeck.getName());
                }
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editedDeck.change(Saving.readFile(newName).getFlashcards(), newName);
                dispose();
            }
        });
    }
}
