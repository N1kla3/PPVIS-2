package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    JMenuBar menu;
    JMenu fileMenu;
    JMenu editMenu;

    JMenuItem find;
    JMenuItem addInfo;
    JMenuItem removeInfo;

    JMenuItem save;
    JMenuItem loadFile;

    MenuPanel(){
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        menu = new JMenuBar();
        menu.setMaximumSize(new Dimension(100, 20));
        createEditMenu();
        createFileMenu();
        add(menu);
        add(Box.createHorizontalGlue());
    }

    private void createFileMenu(){
        fileMenu = new JMenu("File");
        save = new JMenuItem("Save");

        loadFile = new JMenuItem("Open");
        fileMenu.add(save);
        fileMenu.add(loadFile);

        menu.add(fileMenu);
    }

    private void createEditMenu(){
        editMenu = new JMenu("Edit");
        find = new JMenuItem("Find");
        addInfo = new JMenuItem("Add");
        removeInfo = new JMenuItem("Delete");

        editMenu.add(find);
        editMenu.add(addInfo);
        editMenu.add(removeInfo);

        menu.add(editMenu);
    }
}
