package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private List<MyData> tableData;

    DataController(){
        tableData = new ArrayList<MyData>();
    }

    public List<MyData> FindStudents(String name, int minTitul, int maxTitul, String type, String Category){
        List<MyData> temp = new ArrayList<>();

        boolean bName = (name.equals(""));
        boolean bTitul = (minTitul == 0 && maxTitul == 0);
        boolean bType = (type.equals("All"));
        boolean bCategory = (Category.equals("All"));

        for(int i = 0; i < tableData.size(); i++){
            if((tableData.get(i).getName().equals(name)||bName)
                &&(tableData.get(i).getTitul() >= minTitul && tableData.get(i).getTitul() <= maxTitul || bTitul)
                &&(tableData.get(i).getType().equals(type)||bType)
                &&(tableData.get(i).getCategory().equals(Category)||bCategory)){
                temp.add(tableData.get(i));
            }
        }
        return temp;
    }

    public int DeleteStudents(String name, int minTitul, int maxTitul, String type, String Category){
        int temp = 0;
        boolean bName = (name.equals(""));
        boolean bTitul = (minTitul == 0 && maxTitul == 0);
        boolean bType = (type.equals("All"));
        boolean bCategory = (Category.equals("All"));

        List<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < tableData.size(); i++){
            if((tableData.get(i).getName().equals(name)||bName)
                    &&(tableData.get(i).getTitul() >= minTitul && tableData.get(i).getTitul() <= maxTitul || bTitul)
                    &&(tableData.get(i).getType().equals(type)||bType)
                    &&(tableData.get(i).getCategory().equals(Category)||bCategory)){
                indexes.add(i);
                temp++;
            }
        }
        for(int i = indexes.size()-1; i >= 0; i--){
            tableData.remove((int)indexes.get(i));
        }
        return temp;
    }

    public void Add(MyData student){
        tableData.add(student);
    }

    public void Read(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(pathToFile);
        tableData = sax.getStudents();
    }

    public void Write(String pathToFile){
        Dom.setStuds(tableData, pathToFile);
        Dom.setBooks();
    }

    public MyData atIndex(int index){
        return tableData.get(index);
    }

    public boolean isExists(int index){
        return index < tableData.size();
    }

    public void setStudents(List<MyData> data){
        tableData = data;
    }
}
