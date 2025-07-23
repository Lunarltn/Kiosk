package com.example.enums;

import java.sql.Statement;

/**
 * 유저의 종류와 할인율을 관리하는 열거형
 */
public enum User {
    NMP("국가유공자", 0.1),
    Soldier("군인", 0.05),
    Student("학생", 0.05),
    General("일반", 0);

    private final String name;
    private final double discount;

    User(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

    //getter
    public double getDiscount() {
        return discount;
    }

    //getter
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + " : " + (getDiscount() * 100) + "%";
    }

    public static void displayDiscount() {
        for (int i = 0; i < values().length; i++) {
            User user = values()[i];
            System.out.println(i + 1 + ". " + user.toString());
        }
    }
}
