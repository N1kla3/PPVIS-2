package com.company;

public class MyData {
    private String name;
    private String group;
    private String position;
    private int titul;
    private String type;
    private String category;

    MyData(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTitul() {
        return titul;
    }

    public void setTitul(int titul) {
        this.titul = titul;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    MyData(String name, String group, String position, int titul, String type, String category){
        this.name = name;
        this.group = group;
        this.position = position;
        this.titul = titul;
        this.type = type;
        this.category = category;
    }
}
