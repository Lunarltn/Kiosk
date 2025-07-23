package com.example.kiosk;

import com.example.enums.MenuType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MenuItem 클래스를 관리하는 클래스
 */
public class Menu {
    private final Map<MenuType, List<MenuItem>> menuItems = new HashMap<>();

    Menu() {
        for (MenuType menuType : MenuType.values())
            menuItems.put(menuType, new ArrayList<>());
    }

    //getter
    public List<MenuItem> getMenuItems(MenuType menuType) {
        return List.copyOf(menuItems.get(menuType));
    }

    //getter
    public MenuItem getMenuItem(MenuType menuType, int index) {
        return menuItems.get(menuType).get(index);
    }

    //setter
    public void addMenuItem(MenuType menuType, String name, double price, String comment) {
        menuItems.get(menuType).add(new MenuItem(name, price, comment));
    }

    /**
     * {@link MenuType}의 메뉴들을 콘솔에 출력한다.
     *
     * <p>메뉴와 선택지를 출력한다.</p>
     *
     * @param menuType 출력할 메뉴의 타입
     */
    public void displayMenuItem(MenuType menuType) {
        System.out.println(menuType.getMenuName());
        AtomicInteger i = new AtomicInteger(1);
        menuItems.get(menuType).forEach(s -> System.out.println(i.getAndIncrement() + ". " + s));
        System.out.println("0. 뒤로가기");
    }

    /**
     * 메뉴판을 콘솔에 출력한다.
     */
    public void displayMenuList() {
        for (int i = 0; i < MenuType.values().length; i++)
            System.out.println(i + 1 + ". " + MenuType.values()[i].toString() + "s");
    }
}
