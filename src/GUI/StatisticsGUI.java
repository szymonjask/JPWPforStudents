package GUI;

import logic_layer.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsGUI extends JFrame{
    private JButton backButton;
    private JScrollPane scrollTextPanel;
    private JTextArea wordsArea;
    private JPanel panel1;
    private JTextArea generalStatsText;


    public StatisticsGUI(FlashcardPackage set) {
        setContentPane(panel1);
        Stats stats = new Stats();
        generalStatsText.append("Przerobione fiszki: " + stats.getAllNo() + " | "
                + "Dobrych odpowiedzi: " + stats.getAllCorrectNo() + " | "
                + "Nadmiarowych fiszek: " + stats.getAllCounterNo());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        if(set.getFlashcards() != null) {
            for (Flashcard flashcard : set.getFlashcards()) {
                wordsArea.append((flashcard.getWord() + "(" + flashcard.getTranslation() + ")" + "\n"
                        + "Good answers: " + flashcard.getCorrect_answer() + "\n"
                        + "All answers: " + flashcard.getAll_answer() + "\n")
                        + "_____________________\n");
            }
        }
    }
}
