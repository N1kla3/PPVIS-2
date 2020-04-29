package com.company;

import javax.swing.*;
import java.util.List;

public class TablePanel extends JPanel {
    DataController DC;

    JTable table;
    JPanel controlPane;
    JLabel count;
    JLabel page;

    int left;
    int right;
    int pageCounter;

    TablePanel(DataController DC){
        this.DC = DC;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        table = new JTable(10,6);

        makeControlButtons();
        createLabels();
        add(table);
        add(controlPane);
    }

    public void createLabels(){
        JPanel labelPanel = new JPanel();
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

        add(labelPanel);
    }

    void makeControlButtons(){
        left = 1;
        right = 10;
        pageCounter = 1;

        controlPane = new JPanel();
        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.LINE_AXIS));
        count = new JLabel("Students " + left + " - " + right);
        page = new JLabel("Page: " + pageCounter);

        JButton nextPage = new JButton("Next");
        nextPage.addActionListener(actionEvent -> {
            if(DC.isExists(right+1)) {
                left += 10;
                right += 10;
                pageCounter++;
                count.setText("Students " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        JButton prevPage = new JButton("Previous");
        prevPage.addActionListener(actionEvent -> {
            if(pageCounter > 1) {
                left -= 10;
                right -= 10;
                pageCounter--;
                count.setText("Students " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        controlPane.add(count);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(page);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(prevPage);
        controlPane.add(nextPage);
    }

    private void addStudent(int row, MyData student){
        table.setValueAt(student.getName(), row, 0);
        table.setValueAt(student.getGroup(), row, 1);
        table.setValueAt(student.getPosition(), row, 2);
        table.setValueAt(student.getTitul(), row, 3);
        table.setValueAt(student.getType(), row, 4);
        table.setValueAt(student.getCategory(), row, 5);
    }

    private void addEmpty(int row){
        table.setValueAt(" ", row, 0);
        table.setValueAt(" ", row, 1);
        table.setValueAt(" ", row, 2);
        table.setValueAt(" ", row, 3);
        table.setValueAt(" ", row, 4);
        table.setValueAt(" ", row, 5);
    }

    public void setStudents(DataController data){
        DC = data;
    }
    
    public  void showTable(DataController DC){
        int index = 0;
        for(int i = left-1; i < right; i++){
            if(DC.isExists(i)) {
                addStudent(index, DC.atIndex(i));
            }else{
                addEmpty(index);
            }
            index++;
        }
    }
}
