package com.company;

import javax.swing.*;
import java.awt.*;

public class FindFrame extends JFrame {
    DataController DC;

    JButton findButton;
    TablePanel tablePanel;
    ChoosePanel choosePanel = new ChoosePanel();

    FindFrame(DataController DC){
        super("Find Student");
        this.DC = DC;
        setSize(500, 320);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        findButton = new JButton("Find");
        findButton.addActionListener(actionEvent -> {
            String name = choosePanel.name.getText();
            int min, max;
            if(choosePanel.minTitul.getText().equals("")){
                min = 0;
            }else{
                min = Integer.parseInt(choosePanel.minTitul.getText());
            }
            if(choosePanel.maxTitul.getText().equals("")){
                max = 0;
            }else{
                max = Integer.parseInt(choosePanel.maxTitul.getText());
            }
            String type = (String) choosePanel.type.getSelectedItem();
            String category = (String) choosePanel.category.getSelectedItem();
            DataController temp = new DataController();
            temp.setStudents(this.DC.FindStudents(name, min, max, type, category));
            tablePanel.showTable(temp);
        });
        tablePanel = new TablePanel(DC);
        JPanel pan = new JPanel();
        pan.add(findButton);

        add(choosePanel);
        add(pan);
        add(tablePanel);
    }

}
