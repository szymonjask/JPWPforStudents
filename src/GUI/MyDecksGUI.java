package GUI;

import logic_layer.FlashcardPackage;
import logic_layer.Saving;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class MyDecksGUI extends JFrame {
    private JPanel panel1;
    private JButton loadButton;
    private JComboBox comboBox1;
    private JButton backButton;
    private JButton viewButton;
    private JButton editButton;

    private FlashcardPackage currentPackage;

    public MyDecksGUI(ArrayList<FlashcardPackage> Sets, FlashcardPackage currPack, JButton startButton,
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
                currPack.change(toLoad.getFlashcards(), toLoad.getName());

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
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPack.makeNull();
                easyMode.setVisible(false);
                hardMode.setVisible(false);
                startButton.setEnabled(true);
                //currLabel.setText("brak"); <--- Po zrobieniu drugiego zadania mozna odkomentowac
                isCorrect.setText("");
                FlashcardPackage deck = (FlashcardPackage) comboBox1.getSelectedItem();
                JFrame f = new EditDeckGUI(deck);
                f.setTitle("Edycja zestawu");
                f.pack();
                f.setVisible(true);
                dispose();
                f.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        String newName = deck.getName();
                        deck.change(Saving.readFile(newName).getFlashcards(), newName);
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
        });
    }
}
