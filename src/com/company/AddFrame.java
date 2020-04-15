package com.company;

import javax.swing.*;
import java.awt.*;

public class AddFrame extends JFrame {

    JPanel labelPanel;
    JPanel textPanel;

    DataController DC;

    JTextField name;
    JTextField group;
    JTextField position;
    JTextField titul;
    JComboBox<String> type;
    JComboBox<String> category;

    JButton add;

    AddFrame(DataController DC){
        super("Add Window");
        this.DC = DC;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add = new JButton("Add");
        createFields();
        createLabels();

        add(labelPanel);
        add(textPanel);
        add(add);

        setSize(500, 150);
        setResizable(false);
    }

    public void createLabels(){
        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel name = new JLabel("name");
        JLabel group = new JLabel("group");
        JLabel position = new JLabel("position");
        JLabel titul = new JLabel("titul");
        JLabel type = new JLabel("type");
        JLabel category = new JLabel( "category");

        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(group);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(position);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(titul);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(type);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(category);
    }

    public void createFields(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 100;
        final int HEIGHT = 20;

        String[] types = new String[] {"Офис", "Склад", "Гараж",
                "Производство", "Столовая"};
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
        for (int i = 0; i < types.length; i++)
            cbModel.addElement(types[i]);
        type = new JComboBox<>(cbModel);

        String[] categories = new String[] {"Офис", "Склад", "Гараж",
                "Производство", "Столовая"};
        DefaultComboBoxModel<String> cbbModel = new DefaultComboBoxModel<String>();
        for (int i = 0; i < categories.length; i++)
            cbbModel.addElement(categories[i]);
        category = new JComboBox<>(cbbModel);

        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        group = new JTextField();
        group.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        position = new JTextField();
        position.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        titul = new JTextField();
        titul.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        type.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        category.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(group);
        textPanel.add(position);
        textPanel.add(titul);
        textPanel.add(type);
        textPanel.add(category);
    }

    public void addStudent(){
        String name_ = name.getText();
        String group_ = group.getText();
        String position_ = position.getText();
        int titul_ = (titul.getText().equals("") ? 0 : Integer.parseInt(titul.getText()));
        String type_ = String.valueOf(type.getSelectedItem());
        String category_ = String.valueOf(category.getSelectedItem());
        DC.Add(new MyData(name_, group_, position_, titul_, type_, category_));
    }

}
