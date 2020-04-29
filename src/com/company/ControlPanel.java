package com.company;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    final int WIDTH = 60;
    final int HEIGHT = 40;

    JButton add;
    JButton delete;
    JButton find;

    ControlPanel(){
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        add = new JButton("Add");
        add.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        add(add);

        add(Box.createHorizontalGlue());

        delete = new JButton("Delete");
        delete.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        add(delete);

        add(Box.createHorizontalGlue());

        find = new JButton("Find");
        find.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        add(find);
    }
}
