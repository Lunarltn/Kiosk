package com.example.kiosk;

import com.example.enums.MenuType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MenuItem 클래스를 관리하는 클래스
 */
public class Menu {
    private final Map<MenuType, List<MenuItem>> menuItems = new HashMap<>();

    Menu() {
        menuItems.put(MenuType.Burger, new ArrayList<>());
        menuItems.put(MenuType.Drink, new ArrayList<>());
        menuItems.put(MenuType.Dessert, new ArrayList<>());
    }

    //getter
    public List<MenuItem> getMenuItems(MenuType menuType) {
        return List.copyOf(menuItems.get(menuType));
    }

    //setter
    public void addMenuItem(MenuType menuType, String name, double price, String comment) {
        menuItems.get(menuType).add(new MenuItem(name, price, comment));
    }

    //메뉴 이름 반환
    public String getMenuName(MenuType menuType) {
        return menuType.getMenuName();
    }
}
