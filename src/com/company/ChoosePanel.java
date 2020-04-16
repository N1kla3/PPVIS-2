package com.company;

import javax.swing.*;
import java.awt.*;

public class ChoosePanel extends JPanel {

    JPanel textPanel;

    JTextField name;
    JTextField minTitul;
    JTextField maxTitul;
    JComboBox<String> type;
    JComboBox<String> category;

    ChoosePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createLabels();
        createText();
    }

    private void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel name = new JLabel("name");
        JLabel minTitul = new JLabel("min titul");
        JLabel maxTitul = new JLabel("max titul");
        JLabel type = new JLabel("type");
        JLabel category = new JLabel( "category");

        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(minTitul);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(maxTitul);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(type);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(category);

        add(labelPanel);
    }

    private void createText(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 100;
        final int HEIGHT = 20;

        String[] types = new String[] {"All", "Баскетбол", "Шахматы", "Шашки", "Футбол", "Плавание"};
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();
        for (String s : types) cbModel.addElement(s);
        type = new JComboBox<>(cbModel);

        String[] categories = new String[] {"All", "1-й юношеский", "2-й разряд", "3й-разряд", "кмс", "мастер спорта"};
        DefaultComboBoxModel<String> cbbModel = new DefaultComboBoxModel<>();
        for (String s : categories) cbbModel.addElement(s);
        category = new JComboBox<>(cbbModel);

        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        name.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        minTitul = new JTextField();
        minTitul.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        minTitul.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        maxTitul = new JTextField();
        maxTitul.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        maxTitul.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        type.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        category.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(minTitul);
        textPanel.add(maxTitul);
        textPanel.add(type);
        textPanel.add(category);

        add(textPanel);
    }
}
