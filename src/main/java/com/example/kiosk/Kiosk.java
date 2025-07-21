package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 프로그램 순서 및 흐름 제어 담당
 */
public class Kiosk {
    List<MenuItem> menuItems = new ArrayList<MenuItem>();

    Kiosk() {
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.print(i + 1 + ". " + menuItems.get(i).getName() + " | ");
                System.out.print("W " + menuItems.get(i).getPrice() + " | ");
                System.out.println(menuItems.get(i).getComment());
            }
            System.out.println("0. 종료");
            try {
                int selection = sc.nextInt();
                if (selection == 0)
                    break;
                else if (!(selection > 0 && selection <= menuItems.size())) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("[Error] 올바른 메뉴를 선택해 주세요.");
                sc.nextLine();
            }
        }
    }
}
