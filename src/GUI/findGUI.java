package GUI;

import logic_layer.FlashcardPackage;
import logic_layer.Saving;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class findGUI extends JFrame {
    private JPanel panel1;
    private JButton cancelButton;
    private JButton findButton;
    private JTextField findField;
    private JLabel translationLabel;

    private String lastFinding;
    private ArrayList<String> results;

    public findGUI() {
        setContentPane(panel1);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //sprawdza czy się zmieniło szukane słowo, jeżeli nie, to wyświetla następne tłumaczenie
                if(findField.getText().strip().equals(lastFinding)) {
                    translationLabel.setText(results.get((results.indexOf(translationLabel.getText())+1) % results.size()));
                //jeśli słowo się zmieniło i nie jest puste to szuka tłumaczeń
                } else if (!findField.getText().strip().isEmpty()) {
                    results = null;
                    String find = findField.getText().strip().toLowerCase();
                    lastFinding = find;
                    try {
                        File starting = new File(System.getProperty("user.dir"));

                        results = new ArrayList<String>();
                        File basic = new File(starting, "\\basicSets\\");
                        for(int i = 0; i < Objects.requireNonNull(basic.list()).length; i++){
                            String name = Objects.requireNonNull(basic.list())[i].split("\\.")[0];
                            FlashcardPackage pack = Saving.readBasic(name);
                            for (int j = 0; j < Objects.requireNonNull(pack).getFlashcards().size(); j++){
                                if(find.equals(pack.getFlashcards().get(j).getWord())){
                                    String translate = pack.getFlashcards().get(j).getTranslation();
                                    if (!results.contains(translate)) {
                                        results.add(translate);
                                    }
                                }
                            }
                        }

                        basic = new File(starting, "\\saves\\");
                        for(int i = 0; i < Objects.requireNonNull(basic.list()).length; i++){
                            String name = Objects.requireNonNull(basic.list())[i].split("\\.")[0];
                            FlashcardPackage pack = Saving.readFile(name);
                            for (int j = 0; j < Objects.requireNonNull(pack).getFlashcards().size(); j++){
                                if(find.equals(pack.getFlashcards().get(j).getWord())){
                                    String translate = pack.getFlashcards().get(j).getTranslation();
                                    if (!results.contains(translate)) {
                                        results.add(translate);
                                    }
                                }
                            }
                        }
                        if(results.size() > 0){
                            translationLabel.setText(results.get(0));
                        }else{
                            translationLabel.setText("Nie znaleziono");
                            lastFinding = null;
                        }


                    }catch(Exception er){
                        System.out.println("Blad przy wczytywaniu zestawow");
                    }
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
