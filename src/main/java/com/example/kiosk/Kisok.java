package com.example.kiosk;

import java.util.Scanner;

/**
 * 프로그램 순서 및 흐름 제어 담당
 */
public class Kisok {
    public void viewMenu() {
        Menu menuSHAKESHACK = new Menu();
        menuSHAKESHACK.addMenuItem();
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuSHAKESHACK.menuItems.size(); i++) {
                System.out.print(i + 1 + ". " + menuSHAKESHACK.menuItems.get(i).getName() + " | ");
                System.out.print("W " + menuSHAKESHACK.menuItems.get(i).getPrice() + " | ");
                System.out.println(menuSHAKESHACK.menuItems.get(i).getComment());
            }
            System.out.println("0. 종료");
            Scanner sc = new Scanner(System.in);
            int selection = sc.nextInt();
            if (selection == 0)
                break;
        }
    }
}
