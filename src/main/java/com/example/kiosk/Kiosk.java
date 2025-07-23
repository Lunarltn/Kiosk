package com.example.kiosk;

import com.example.enums.MenuType;
import com.example.enums.User;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 프로그램 순서 및 흐름 제어 담당
 */
public class Kiosk {
    private final Menu menu;
    private final Cart cart = new Cart();

    public Kiosk(Menu menu) {
        this.menu = menu;
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
            displayMainMenu();
            // 카트안에 아이템이 있다면 오더 메뉴 출력
            if (!cart.getCart().isEmpty())
                displayOrderMenu();

            try {
                int selection
                        = readIntInRange(sc, 0, cart.getCart().isEmpty() ? 3 : 5);

                switch (selection) {
                    case 1:
                        runMenu(MenuType.Burger);
                        break;
                    case 2:
                        runMenu(MenuType.Drink);
                        break;
                    case 3:
                        runMenu(MenuType.Dessert);
                        break;
                    case 4:
                        runOrderWithDiscount(sc);
                        break;
                    case 5:
                        CancelOrder(sc);
                        break;
                    case 0:
                        break;
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
     * 주어진 메뉴 타입의 항목을 콘솔에 출력하고, 사용자의 선택을 처리한다.
     *
     * <p>메뉴 타입에 맞는 {@link MenuItem}들을 콘솔에 출력하고,
     * 입력에 맞는 {@link MenuItem}을 장바구니에 담는다.
     * 0과 메뉴 이외의 숫자나 문자를 입력한 경우 {@link MenuItem}들을 콘솔에 출력하고 다시 입력을 받는다.</p>
     *
     * @param menuType 출력할 메뉴의 타입
     */
    private void runMenu(MenuType menuType) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu.displayMenuItem(menuType);

            try {
                int menuSelection = readIntInRange(sc, 0, menu.getMenuItems(menuType).size());
                if (menuSelection == 0)
                    break;

                int index = menuSelection - 1;

                System.out.println("선택한 메뉴: " + menu.getMenuItem(menuType, index).toString());
                System.out.println("\n" + '"' + menu.getMenuItem(menuType, index).toString() + '"');
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인      2. 취소");

                int checkSelection = readIntInRange(sc, 1, 2);
                if (checkSelection == 1) {
                    cart.addItem(menu.getMenuItem(menuType, index));
                } else if (checkSelection == 2)
                    break;

            } catch (InputMismatchException e) {
                System.out.println("[Error] 입력이 올바르지 않습니다.");
                sc.nextLine();
            }
        }
    }

    /**
     * 카트에 담긴 주문들을 출력하고, 주문을 받으면 주문총액에 할인율을 적용해 출력한다.
     *
     * <p>카트에 담긴 아이템들과 합계를 출력하고,
     * 사용자의 입력을 받아 주문을 처리한다.
     * 주문시 할인 유형을 입력받아 할인율을 적용한 주문총액을 콘솔에 출력한다.
     * 0과 메뉴 이외의 숫자나 문자를 입력한 경우 주문이 취소된다.</p>
     */
    private void runOrderWithDiscount(Scanner sc) {
        while (true) {
            cart.displayCartOrder();

            try {
                int menuSelection = readIntInRange(sc, 1, 2);
                if (menuSelection == 1) {
                    runDiscount(sc);
                    break;
                } else if (menuSelection == 2)
                    break;
            } catch (InputMismatchException e) {
                System.out.println("[Error] 입력이 올바르지 않습니다.");
            }
        }
    }

    /**
     * 할인 정보를 입력받아 할인율이 적용된 주문총액을 콘솔에 출력한다.
     *
     * <p>장바구니에 담긴 메뉴들의 총액에 할인율을 적용해 출력하고, 장바구니를 비운다.</p>
     */
    void runDiscount(Scanner sc) {
        while (true) {
            System.out.println("할인 정보를 입력해주세요.");
            User.displayDiscount();

            try {
                int discountSelection = readIntInRange(sc, 1, User.values().length);

                int index = discountSelection - 1;
                double price = cart.getCartTotalPrice();
                double totalPrice = price
                        - price * User.values()[index].getDiscount();

                System.out.println("\n주문이 완료되었습니다. 금액은 W " + String.format("%.2f", totalPrice) + " 입니다.");
                cart.clearCart();
                break;
            } catch (InputMismatchException e) {
                System.out.println("[Error] 입력이 올바르지 않습니다.");
            }
        }
    }

    /**
     * 사용자 입력을 받아 카트에 있는 주문을 취소한다.
     */
    private void CancelOrder(Scanner sc) {
        while (true) {
            System.out.println("취소할 메뉴명을 입력해 주세요.");
            cart.displayCart();
            System.out.println("0. 종료");

            try {
                String input = sc.next();
                if (input.equals("0"))
                    break;

                cart.deleteItem(input);
                System.out.println("주문이 취소되었습니다.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("해당 이름을 가진 메뉴를 찾을 수 없습니다.");
                sc.nextLine();
            }
        }
    }

    /**
     * 입력받은 정수가 밤위 내 일때만 반환한다.
     *
     * @param sc    {@link Scanner}의 인스턴스
     * @param start 시작 정수
     * @param end   끝 정수
     * @return 범위 내의 정수를 반환한다.
     */
    private int readIntInRange(Scanner sc, int start, int end) throws InputMismatchException {
        int input = sc.nextInt();
        if (input < start || input > end)
            throw new InputMismatchException("[Error] 입력값은 " + start + "부터 " + end + " 사이여야 합니다.");
        return input;
    }

    /**
     * 메인 메뉴 콘솔 출력
     */
    void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        menu.displayMenuList();
        System.out.println("0. 종료      | 종료");
    }

    /**
     * 오더 메뉴 콘솔 출력
     */
    void displayOrderMenu() {
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders   | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel   | 진행중인 주문을 취소합니다.");
    }
}
