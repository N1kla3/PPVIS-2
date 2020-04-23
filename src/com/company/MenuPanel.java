package com.company;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JMenuBar menu;

    private JMenu fileMenu;
    private JMenu editMenu;

    private JMenuItem find;
    private JMenuItem addInfo;

    private JMenuItem removeInfo;

    private JMenuItem save;

    private JMenuItem loadFile;

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

    public JMenuItem getFind() {
        return find;
    }

    public JMenuItem getAddInfo() {
        return addInfo;
    }

    public JMenuItem getRemoveInfo() {
        return removeInfo;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getLoadFile() {
        return loadFile;
    }
}
