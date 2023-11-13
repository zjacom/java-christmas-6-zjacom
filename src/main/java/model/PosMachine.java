package model;

import java.util.List;
import java.util.Map;

public class PosMachine {
    private int totalOrderPrice = 0;

    // (음식 이름, 개수)을 입력 받아서 총 주문 금액 계산
    public int calculateTotalOrderPrice(OrderedMenu orderedMenu, Menu menu) {
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        for (Map.Entry<String, Integer> menuInfo : orderedMenus.entrySet()) {
            String menuName = menuInfo.getKey();
            int menuQuantity = menuInfo.getValue();

            totalOrderPrice += menu.findMenuPrice(menuName) * menuQuantity;
        }
        return totalOrderPrice;
    }

    // 할인 정보와 증정품 가격을 입력받아 총 혜택 금액 계산
    public int calculateTotalBenefitPrice(List<Integer> discountDetails, int giftPrice) {
        int totalDiscountPrice = calculateTotalDiscountPrice(discountDetails);
        return totalDiscountPrice + giftPrice;
    }

    // 할인 정보를 입력받아 총 할인 금액을 계산
    private int calculateTotalDiscountPrice(List<Integer> discountDetails) {
        int totalDiscountPrice = 0;
        if (!discountDetails.isEmpty()) {
            for (int discountPrice : discountDetails) {
                totalDiscountPrice += discountPrice;
            }
        }
        return totalDiscountPrice;
    }

    // 총주문 금액과 할인 정보를 입력받아서 예상결제금액 리턴
    public int calculatePayment(List<Integer> discountDetails) {
        return totalOrderPrice - calculateTotalDiscountPrice(discountDetails);
    }

    // 총 주문 금액 리턴
    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
