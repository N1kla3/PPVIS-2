package com.company;

import javax.swing.*;
import java.awt.*;

public class DelFrame extends JFrame {
    DataController DC;

    ChoosePanel cPanel = new ChoosePanel();

    JButton delete;

    DelFrame(DataController DC){
        super("Delete frame");
        this.DC = DC;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        init();
        setSize(400, 120);
        setResizable(false);
    }

    private void init() {
        delete = new JButton("Delete");


        delete.setMaximumSize(new Dimension(100, 20));

        add(cPanel);
        add(delete);
    }

    public int deleteStudents(){
        String name = cPanel.name.getText();
        int min, max = 0;
        if(cPanel.minTitul.getText().equals("")){
            min = 0;
        }else{
            min = Integer.parseInt(cPanel.minTitul.getText());
        }
        if(cPanel.maxTitul.getText().equals("")){
            max = 0;
        }else{
            max = Integer.parseInt(cPanel.maxTitul.getText());
        }
        String type = (String) cPanel.type.getSelectedItem();
        String category = (String) cPanel.category.getSelectedItem();
        return  this.DC.DeleteStudents(name, min, max, type, category);
    }
}
