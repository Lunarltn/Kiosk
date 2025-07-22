package com.example.kiosk;

import java.nio.DoubleBuffer;
import java.util.List;
import java.util.ArrayList;

/**
 * 사용자가 선택한 {@link MenuItem}를 관리하는 클래스
 */
public class Cart {
    private final List<MenuItem> cart = new ArrayList<>();

    //getter
    public List<MenuItem> getCart() {
        return List.copyOf(cart);
    }

    /**
     * 카트에 아이템을 추가하고 아이템의 이름을 콘솔에 출력한다.
     *
     * @param menuItem 카트에 추가할 {@link MenuItem}
     */
    public void addItem(MenuItem menuItem) {
        cart.add(menuItem);
        System.out.println(menuItem.getName() + "이 장바구니에 추가되었습니다.");
    }

    /**
     * 카트에 있는 아이템들을 콘솔에 출력한다.
     */
    public void printCartList() {
        for (MenuItem menuItem : cart)
            System.out.println(menuItem.formatMenuItem());
    }

    /**
     * 카트에 있는 아이템들의 가격 합계를 반환한다.
     */
    public double getCartTotalPrice() {
        double sum = 0;
        for (MenuItem menuItem : cart) {
            sum += menuItem.getPrice();
        }
        return sum;
    }

    /**
     * 카트에 있는 아이템들을 모두 지운다.
     */
    public void clearCart() {
        cart.clear();
    }
}
