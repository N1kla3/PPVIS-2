package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    private String name;
    private String group;
    private String position;
    private int titul;
    private String type;
    private String category;

    private String endEl;

    private MyData student;
    private static List<MyData> students = new ArrayList<>();

    public void parse(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bName = false;
                boolean bGroup = false;
                boolean bPosition = false;
                boolean bTitul = false;
                boolean bType = false;
                boolean bCategory = false;


                public void startElement(String uri, String localName, String queryName,
                                         Attributes attributes) throws SAXException {
                    if (queryName.equalsIgnoreCase(EValidParams.NAME.toString())) {
                        bName = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.GROUP.toString())) {
                        bGroup = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.POSITION.toString())) {
                        bPosition = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.TITUL.toString())) {
                        bTitul = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.TYPE.toString())) {
                        bType = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.CATEGORY.toString())) {
                        bCategory = true;
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    endEl = qName;


                }

                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (bName) {
                        System.out.println("name: " + new String(ch, start, length));
                        setName(new String(ch, start, length));
                        bName = false;
                    } else if (bGroup) {
                        System.out.println("group : " + new String(ch, start, length));
                        setGroup(new String(ch, start, length));
                        bGroup = false;
                    } else if (bPosition) {
                        System.out.println("position : " + new String(ch, start, length));
                        setPosition(new String(ch, start, length));
                        bPosition = false;
                    } else if (bTitul) {
                        System.out.println("titul : " + new String(ch, start, length));
                        setTitul(Integer.parseInt(new String(ch, start, length)));
                        bTitul = false;
                    } else if (bType) {
                        System.out.println("type : " + new String(ch, start, length));
                        setType(new String(ch, start, length));
                        bType = false;
                    } else if (bCategory) {
                        System.out.println("category : " + new String(ch, start, length));
                        setCategory(new String(ch, start, length));
                        bCategory = false;
                        MyData book = new MyData();
                        book.setName(getName());
                        book.setGroup(getGroup());
                        book.setPosition(getPosition());
                        book.setTitul(getTitul());
                        book.setType(getType());
                        book.setCategory(getCategory());
                        students.add(book);
                    }

                }

            };

            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static List<MyData> getStudents() {
        return students;
    }

    public MyData getStudent() {
        return student;
    }



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
}
