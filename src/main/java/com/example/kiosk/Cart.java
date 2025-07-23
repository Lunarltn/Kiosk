package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 사용자가 선택한 {@link MenuItem}를 관리하는 클래스
 */
public class Cart {
    private List<MenuItem> cart = new ArrayList<>();

    //getter
    public List<MenuItem> getCart() {
        return List.copyOf(cart);
    }

    /**
     * 장바구니에 아이템을 추가하고 아이템의 이름을 콘솔에 출력한다.
     *
     * @param menuItem 카트에 추가할 {@link MenuItem}
     */
    public void addItem(MenuItem menuItem) {
        cart.add(menuItem);
        System.out.println(menuItem.getName() + "이 장바구니에 추가되었습니다.");
    }

    /**
     * 장바구니 주문 내용을 콘솔에 출력한다.
     *
     * <p>장바구니에 있는 아이템, 주문총액과 선택지를 콘솔에 출력한다.</p>
     */
    public void displayCartOrder() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ Orders ]");
        displayCart();
        System.out.println("\n[ Total ]");
        System.out.println("W " + getCartTotalPrice());
        System.out.println("\n1. 주문      2. 메뉴판");
    }

    /**
     * 장바구니에 있는 아이템들을 콘솔에 출력한다.
     */
    public void displayCart() {
        cart.forEach(System.out::println);
    }

    /**
     * 장바구니에 있는 아이템들의 가격 합계를 반환한다.
     */
    public double getCartTotalPrice() {
        double sum = 0;
        for (MenuItem menuItem : cart) {
            sum += menuItem.getPrice();
        }
        return Math.round(sum * 10) / 10.0;
    }

    /**
     * 장바구니에서 {@code name}의 이름을 가진 요소를 제거한다.
     *
     * <p>제거할 요소가 없을경우 예외를 반환한다.</p>
     *
     * @param name 제거할 요소의 이름
     * @throws InputMismatchException 제거요소 없을 시 반환
     */
    public void deleteItem(String name) throws InputMismatchException {
        boolean isMatch = cart.stream()
                .anyMatch(menuItem -> menuItem.getName().equals(name));

        if (isMatch) {
            cart = cart.stream()
                    .filter(menuItem -> {
                        if (!menuItem.getName().equals(name))
                            return true;

                        System.out.println("제거 | " + menuItem);
                        return false;
                    })
                    .collect(Collectors.toList());
        } else
            throw new InputMismatchException();
    }

    /**
     * 장바구니에 있는 아이템들을 모두 지운다.
     */
    public void clearCart() {
        cart.clear();
    }
}
