package com.example.kiosk;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * 시작 지점이 되는 클래스
 */
public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.print(i + 1 + ". " + menuItems.get(i).getName() + " | ");
                System.out.print("W " + menuItems.get(i).getPrice() + " | ");
                System.out.println(menuItems.get(i).getComment());
            }
            System.out.println("0. 종료");
            int selection = sc.nextInt();
            if (selection == 0)
                break;
        }
    }
}
