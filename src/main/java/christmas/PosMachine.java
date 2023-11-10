package christmas;

import java.util.List;
import java.util.Map;

public class PosMachine {
    private int totalOrderAmount = 0;

    // (음식 이름, 개수)을 입력 받아서 총 주문 금액 계산
    public int calculateTotalOrderAmount(OrderedMenu orderedMenu, Menu menu) {
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        for (Map.Entry<String, Integer> menuInfo : orderedMenus.entrySet()) {
            String menuName = menuInfo.getKey();
            int menuQuantity = menuInfo.getValue();

            totalOrderAmount += menu.findMenuPrice(menuName) * menuQuantity;
        }
        return totalOrderAmount;
    }

    // 할인 정보와 증정품 가격을 입력받아 총 혜택 금액 계산
    public int calculateTotalBenefitAmount(List<Integer> discountInfo, int giftPrice) {
        int totalDiscountAmount = calculateTotalDiscountAmount(discountInfo);
        return totalDiscountAmount + giftPrice;
    }

    // 할인 정보를 입력받아 총 할인 금액을 계산
    private int calculateTotalDiscountAmount(List<Integer> discountInfo) {
        int totalDiscountAmount = 0;
        if (!discountInfo.isEmpty()) {
            for (int discountAmount : discountInfo) {
                totalDiscountAmount += discountAmount;
            }
        }
        return totalDiscountAmount;
    }

    // 총주문 금액과 할인 정보를 입력받아서 예상결제금액 리턴
    public int calculatePayment(List<Integer> discountInfo) {
        return totalOrderAmount -= calculateTotalDiscountAmount(discountInfo);
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }
}
