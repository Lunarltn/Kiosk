package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

/**
 * 프로그램 순서 및 흐름 제어 담당
 */
public class Kiosk {
    private final Menu menu;
    private final Cart cart;

    public Kiosk(Menu menu, Cart cart) {
        this.menu = menu;
        this.cart = cart;
    }

    /**
     * 메인 메뉴를 콘솔에 출력하고, 사용자의 선택을 입력받아 추가 메뉴를 콘솔에 출력한다.
     *
     * <p>사용자는 메뉴 항목을 번호로 선택할 수 있으며, "0" 입력시 종료된다.
     * 잘못된 입력을 할 경우 {@link InputMismatchException}이 발생한다.</p>
     *
     * <p>정상적으로 숫자를 입력받으면 해당 메뉴의 {@link MenuItem} 목록을 콘솔에 출력한다.
     * {@code menuItems}로 부터 입력에 맞는 {@link MenuItem}을 콘솔에 출력한다.</p>
     */
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 메인 메뉴 출력
            printMainMenu();
            // 카트안에 아이템이 있다면 오더 메뉴 출력
            if (!cart.getCart().isEmpty())
                printOrderMenu();

            try {
                int selection = sc.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println(menu.getBurgersMenuName());
                        runMenu(menu.getBurgersMenuItems());
                        break;
                    case 2:
                        System.out.println(menu.getDrinksMenuName());
                        runMenu(menu.getDrinksMenuItems());
                        break;
                    case 3:
                        System.out.println(menu.getDessertsMenuName());
                        runMenu(menu.getDessertsMenuItems());
                        break;
                    case 4:
                        if (cart.getCart().isEmpty()) throw new InputMismatchException();
                        runOrder();
                        break;
                    case 5:
                        if (cart.getCart().isEmpty()) throw new InputMismatchException();
                        CancelOrder();
                        break;
                    case 0:
                        break;
                    default:
                        throw new InputMismatchException();
                }
                if (selection == 0)
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
     * <p>{@code menuItems} 항목의 {@link MenuItem}들을 콘솔에 출력하고,
     * 입력에 맞는 {@link MenuItem}을 장바구니에 담는다.
     * 0과 메뉴 이외의 숫자나 문자를 입력한 경우 {@link MenuItem}들을 콘솔에 출력하고 다시 입력을 받는다.</p>
     *
     * @param menuItems 출력할 {@link MenuItem}의 {@link List}
     */
    private void runMenu(List<MenuItem> menuItems) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + 1 + ". " + menuItems.get(i).formatMenuItem());
            }
            System.out.println("0. 뒤로가기");

            try {
                int menuSelection = sc.nextInt();
                if (menuSelection == 0)
                    break;
                else if
                (!(menuSelection > 0 && menuSelection <= menuItems.size()))
                    throw new InputMismatchException();
                int index = menuSelection - 1;

                System.out.println("선택한 메뉴: " + menuItems.get(index).formatMenuItem());
                System.out.println("\n" + '"' + menuItems.get(index).formatMenuItem() + '"');
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인      2. 취소");

                int checkSelection = sc.nextInt();
                if (checkSelection == 1) {
                    cart.addItem(menuItems.get(index));
                } else if (checkSelection == 2) break;
                else throw new InputMismatchException();

            } catch (InputMismatchException e) {
                System.out.println("[Error] 입력이 올바르지 않습니다.");
            }
        }
    }

    /**
     * 카트에 담긴 주문들을 출력하고, 사용자의 선택을 처리한다.
     *
     * <p>카트에 담긴 아이템들과 합계를 출력하고,
     * 사용자의 입력을 받아 주문을 처리한다.
     * 0과 메뉴 이외의 숫자나 문자를 입력한 경우 주문이 취소된다.</p>
     */
    private void runOrder() {
        Scanner sc = new Scanner(System.in);

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ Orders ]");
        cart.printCartList();
        System.out.println("\n[ Total ]");
        System.out.println("W " + cart.getCartTotalPrice());
        System.out.println("\n1. 주문      2. 메뉴판");
        try {
            int menuSelection = sc.nextInt();
            if (menuSelection == 1) {
                System.out.println("\n주문이 완료되었습니다. 금액은 W " + cart.getCartTotalPrice() + " 입니다.");
                cart.clearCart();
            } else if (menuSelection == 2)
                return;
            else throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 입력이 올바르지 않습니다.");
        }
    }

    /**
     * 카트에 있는 주문들을 취소한다.
     */
    private void CancelOrder() {
        cart.clearCart();
        System.out.println("주문이 취소되었습니다.");
    }

    /**
     * 메인 메뉴 콘솔 출력
     */
    void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        System.out.println("0. 종료      | 종료");
    }

    /**
     * 오더 메뉴 콘솔 출력
     */
    void printOrderMenu() {
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders   | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel   | 진행중인 주문을 취소합니다.");
    }
}
