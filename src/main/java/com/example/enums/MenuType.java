package com.example.enums;

public enum MenuType {
    Burger("[ BURGERS MENU ]"),
    Drink("[ DRINKS MENU ]"),
    Dessert("[ DESSERTS MENU ]");

    private final String menuName;

    MenuType(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }
}
