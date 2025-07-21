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

    public String getName() {
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getComment(){
        return comment;
    }
}
