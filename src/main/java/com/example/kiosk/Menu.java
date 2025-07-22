package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 클래스를 관리하는 클래스
 */
public class Menu {
    private final List<MenuItem> burgerMenuItems = new ArrayList<MenuItem>();
    private final List<MenuItem> drinksMenuItems = new ArrayList<MenuItem>();
    private final List<MenuItem> dessertsMenuItems = new ArrayList<MenuItem>();

    //getter
    public List<MenuItem> getBurgersMenuItems() {
        return List.copyOf(burgerMenuItems);
    }

    //getter
    public List<MenuItem> getDrinksMenuItems() {
        return List.copyOf(drinksMenuItems);
    }

    //getter
    public List<MenuItem> getDessertsMenuItems() {

        return List.copyOf(dessertsMenuItems);
    }

    //setter
    public void addBurgersMenuItem(String name, double price, String comment) {
        burgerMenuItems.add(new MenuItem(name, price, comment));
    }

    //setter
    public void addDrinksMenuItem(String name, double price, String comment) {
        drinksMenuItems.add(new MenuItem(name, price, comment));
    }

    //setter
    public void addDessertsMenuItem(String name, double price, String comment) {
        dessertsMenuItems.add(new MenuItem(name, price, comment));
    }

    //버거 메뉴 카테고리 이름 반환
    public String getBurgersMenuName() {
        return "[ BURGERS MENU ]";
    }

    //음료 메뉴 카테고리 이름 반환
    public String getDrinksMenuName() {
        return "[ DRINKS MENU ]";
    }

    //디저트 메뉴 카테고리 이름 반환
    public String getDessertsMenuName() {
        return "[ DESSERTS MENU ]";
    }
}
