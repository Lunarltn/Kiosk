package com.example.kiosk;

import com.example.enums.MenuType;

/**
 * 시작 지점이 되는 클래스
 *
 * <p>이 클래스는 {@code main()}메서드를 포함한다.</p>
 */
public class Main {
    // 메뉴 생성 -> 메뉴 아이템 추가 -> 키오스크 생성 -> 키오스크 실행 순으로 실행된다.
    public static void main(String[] args) {
        Menu menu = new Menu();
        addMenuItemData(menu);

        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }

    // 메뉴 아이템들을 추가한다.
    static void addMenuItemData(Menu menu) {
        menu.addMenuItem(MenuType.Burger, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menu.addMenuItem(MenuType.Burger, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menu.addMenuItem(MenuType.Burger, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menu.addMenuItem(MenuType.Burger, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        menu.addMenuItem(MenuType.Drink, "Coke", 1.5, "코카 콜라");
        menu.addMenuItem(MenuType.Drink, "Soda", 1.5, "사이다");

        menu.addMenuItem(MenuType.Dessert, "IceCream", 2.1, "바닐라 아이스크림");
        menu.addMenuItem(MenuType.Dessert, "FrenchFries", 2.5, "감자 튀김");
    }
}
