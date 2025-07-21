package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

/**
 * 프로그램 순서 및 흐름 제어 담당
 */
public class Kiosk {
    /**
     * 메인 메뉴를 콘솔에 출력하고, 사용자의 선택을 입력받아 추가 메뉴를 콘솔에 출력한다.
     *
     * <p>사용자는 메뉴 항목을 번호로 선택할 수 있으며, "0" 입력시 종료된다.
     * 잘못된 입력을 할 경우 {@link InputMismatchException}이 발생한다.</p>
     *
     * <p>정상적으로 숫자를 입력받으면 해당 메뉴의 {@link MenuItem} 목록을 콘솔에 출력한다.
     * {@code menuItems}로 부터 입력에 맞는 {@link MenuItem}을 콘솔에 출력한다.</p>
     *
     * @param menu {@link MenuItem}들을 관리하고 있는 {@link Menu}의 인스턴스
     */
    public void start(Menu menu) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료");
            try {
                int mainSelection = sc.nextInt();
                switch (mainSelection) {
                    case 1:
                        System.out.println(menu.getBurgersMenuName());
                        startMenu(menu.getBurgersMenuItems(), menu);
                        break;
                    case 2:
                        System.out.println(menu.getDrinksMenuName());
                        startMenu(menu.getDrinksMenuItems(), menu);
                        break;
                    case 3:
                        System.out.println(menu.getDessertsMenuName());
                        startMenu(menu.getDessertsMenuItems(), menu);
                        break;
                    case 0:
                        break;
                    default:
                        throw new InputMismatchException();
                }
                if (mainSelection == 0)
                    break;
            } catch (InputMismatchException e) {
                System.out.println("[Error] 올바른 메뉴를 선택해 주세요.");
                sc.nextLine();
            }
        }
    }

    /**
     * 주어진 {@code menuItems} 항목을 콘솔에 출력하고, 사용자의 선택을 처리한다.
     *
     * <p>{@code menuItems} 항목의 {@link MenuItem} 목록을 콘솔에 출력하고,
     * 입력에 맞는 {@link MenuItem}을 콘솔에 출력한다.
     * 0과 메뉴 이외의 숫자나 문자를 입력한 경우 {@link InputMismatchException}이 발생한다.</p>
     *
     * @param menuItems 출력할 {@link MenuItem}의 {@link List}
     * @param menu      메뉴 항목을 출력하는 데 사용되는 {@link Menu}의 인스턴스
     * @throws InputMismatchException 잘못된 번호 입력시 발생
     */
    void startMenu(List<MenuItem> menuItems, Menu menu) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + 1 + ". ");
            menu.viewMenuItem(menuItems, i);
        }
        System.out.println("0. 뒤로가기");

        int selection = sc.nextInt();
        if (selection > 0 && selection <= menuItems.size()) {
            System.out.print("선택한 메뉴: ");
            menu.viewMenuItem(menuItems, selection);
        } else if (selection != 0)
            throw new InputMismatchException();
    }
}
