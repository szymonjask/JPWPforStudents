package GUI;

import logic_layer.FlashcardPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SetsGUI extends JFrame {
    private JPanel panel1;
    private JButton loadButton;
    private JComboBox comboBox1;
    private JButton backButton;
    private JButton viewButton;

    private FlashcardPackage currentPackage;

    public SetsGUI(ArrayList<FlashcardPackage> Sets, FlashcardPackage curr, JButton startButton,
                   JPanel easyMode, JPanel hardMode, JLabel isCorrect) {
        setContentPane(panel1);
        for(int j = 0; j < Sets.size(); j++){
            if(Sets.get(j).getFlashcards().size()>0) {
                comboBox1.addItem(Sets.get(j));
            }
        }
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlashcardPackage toLoad = (FlashcardPackage) comboBox1.getSelectedItem();
                curr.change(toLoad.getFlashcards(), toLoad.getName());

                startButton.setEnabled(true);
                easyMode.setVisible(false);
                hardMode.setVisible(false);
                isCorrect.setText("");
                dispose();
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Na razie nie wiem jak zrobic dobrze to wyswietlanie
                JFrame f = new BrowserGUI((FlashcardPackage) comboBox1.getSelectedItem());
                f.setTitle("Przeglad");
                f.pack();
                f.setVisible(true);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
