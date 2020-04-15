package com.company;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {

    DataController applData;

    AddFrame addFrame;
    FindFrame findFrame;
    DelFrame delFrame;

    TablePanel tablePanel;

    Main(DataController DC) {
        super("Second lab");
        applData = DC;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(layout);

        addFrame = new AddFrame(applData);
        delFrame = new DelFrame(applData);
        findFrame = new FindFrame(applData);

        FindListener findListener = new FindListener();
        AddListener addListener = new AddListener();
        DelListener delListener = new DelListener();

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.find.addActionListener(findListener);
        menuPanel.addInfo.addActionListener(addListener);
        menuPanel.removeInfo.addActionListener(delListener);
        menuPanel.save.addActionListener(new SaveListener());
        menuPanel.loadFile.addActionListener(new LoadListener());
        panel.add(menuPanel);

        tablePanel = new TablePanel(applData);
        panel.add(tablePanel);

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.delete.addActionListener(delListener);
        controlPanel.find.addActionListener(findListener);
        controlPanel.add.addActionListener(addListener);
        panel.add(controlPanel);

        delFrame.delete.addActionListener(actionEvent -> {
            int amount = delFrame.deleteStudents();
            JOptionPane.showConfirmDialog(this, "Deleted: " + amount);
            tablePanel.showTable(applData);
        });

        addFrame.add.addActionListener(actionEvent -> {
            addFrame.addStudent();
            tablePanel.showTable(applData);
        });

        add(panel);
        setSize(500, 300);

        setVisible(true);
    }

    private class FindListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            findFrame.setVisible(!findFrame.isVisible());
        }
    }

    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            addFrame.setVisible(!addFrame.isVisible());
        }
    }

    private class DelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            delFrame.setVisible(!delFrame.isVisible());
        }
    }

    private class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Special xml file", "xml");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(chooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                applData.Write(path);
            }
        }
    }

    private class LoadListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Special xml file", "xml");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(chooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                try {
                    applData.Read(path);
                    tablePanel.showTable(applData);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DataController dataBase = new DataController();
        new Main(dataBase);

    }
}
