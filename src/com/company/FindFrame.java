package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FindFrame extends JFrame {
    private DataController DC;

    private JButton findButton;

    private TablePanel tablePanel;

    private ChoosePanel choosePanel = new ChoosePanel();
    FindFrame(DataController DC){
        super("Find Student");
        this.DC = DC;
        setSize(500, 320);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        findButton = new JButton("Find");
        findButton.addActionListener(actionEvent -> {
            List<String> list = choosePanel.getStudentFromFields();
            DataController temp = new DataController();
            temp.setStudents(this.DC.FindStudents(list.get(0), Integer.parseInt(list.get(1)),
                    Integer.parseInt(list.get(2)), list.get(3), list.get(4)));
            tablePanel.setStudents(temp);
            tablePanel.showTable(temp);
        });

        tablePanel = new TablePanel(DC);
        JPanel pan = new JPanel();
        pan.add(findButton);

        add(choosePanel);
        add(pan);
        add(tablePanel);
    }

    public DataController getDC() {
        return DC;
    }

    public JButton getFindButton() {
        return findButton;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }
}
