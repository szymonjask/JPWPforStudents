package GUI;

import logic_layer.Flashcard;
import logic_layer.FlashcardPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowserGUI extends JFrame {
    private JTextArea wordsArea;
    private JButton backButton;
    private JPanel panel1;
    private JScrollPane scrollTextPanel;

    public BrowserGUI(FlashcardPackage set) {
        setContentPane(panel1);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        for(Flashcard flashcard : set.getFlashcards()){
            wordsArea.append("  " + flashcard.getWord() + " = " + flashcard.getTranslation() + "\n");
        }
    }
}
