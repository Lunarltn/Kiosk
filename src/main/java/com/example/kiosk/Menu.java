package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 클래스를 관리하는 클래스
 */
public class Menu {
    private List<MenuItem> burgerMenuItems = new ArrayList<MenuItem>();
    private List<MenuItem> drinksMenuItems = new ArrayList<MenuItem>();
    private List<MenuItem> dessertsMenuItems = new ArrayList<MenuItem>();

    //getter
    public List<MenuItem> getBurgersMenuItems() {
        return burgerMenuItems;
    }

    //getter
    public List<MenuItem> getDrinksMenuItems() {
        return drinksMenuItems;
    }

    //getter
    public List<MenuItem> getDessertsMenuItems() {
        return dessertsMenuItems;
    }

    //setter
    public void setBurgersMenuItems(List<MenuItem> burgerMenuItems) {
        this.burgerMenuItems = burgerMenuItems;
    }

    //setter
    public void setDrinksMenuItems(List<MenuItem> drinksMenuItems) {
        this.drinksMenuItems = drinksMenuItems;
    }

    //setter
    public void setDessertsMenuItems(List<MenuItem> dessertsMenuItems) {
        this.dessertsMenuItems = dessertsMenuItems;
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

    /**
     * {@link MenuItem}의 {@link List}로 부터 {@code idx}에 맞는 {@link MenuItem}을 한줄로 콘솔에 출력한다.
     *
     * @param menuItems 출력할 {@link List}
     * @param idx       {@link List}의 index
     */
    public void viewMenuItem(List<MenuItem> menuItems, int idx) {
        if (0 <= idx && menuItems.size() > idx) {
            System.out.print(menuItems.get(idx).getName() + " | ");
            System.out.print("W " + menuItems.get(idx).getPrice() + " | ");
            System.out.println(menuItems.get(idx).getComment());
        }
    }
}
