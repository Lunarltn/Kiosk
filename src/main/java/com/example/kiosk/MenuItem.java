package com.example.kiosk;

/**
 * 세부 메뉴 속성을 가지는 클래스
 */
public class MenuItem {
    private String name;
    private double price;
    private String comment;

    public MenuItem(String name, double price, String comment) {
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    //getter
    public String getName() {
        return name;
    }

    //getter
    public double getPrice() {
        return price;
    }

    //getter
    public String getComment() {
        return comment;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //setter
    public void setPrice(double price) {
        this.price = price;
    }
    
    //setter
    public void setComment(String comment) {
        this.comment = comment;
    }
}
