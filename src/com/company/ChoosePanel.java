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

        String[] types = new String[] {"All", "Офис", "Склад", "Гараж",
                "Производство", "Столовая"};
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
        for (int i = 0; i < types.length; i++)
            cbModel.addElement(types[i]);
        type = new JComboBox<>(cbModel);

        String[] categories = new String[] {"All", "Офис", "Склад", "Гараж",
                "Производство", "Столовая"};
        DefaultComboBoxModel<String> cbbModel = new DefaultComboBoxModel<String>();
        for (int i = 0; i < categories.length; i++)
            cbbModel.addElement(categories[i]);
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
