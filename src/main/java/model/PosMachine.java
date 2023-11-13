package model;

import java.util.List;
import java.util.Map;

public class PosMachine {
    private int totalOrderPrice = 0;

    public int calculateTotalOrderPrice(OrderedMenu orderedMenu) {
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        for (Map.Entry<String, Integer> menuInfo : orderedMenus.entrySet()) {
            String menuName = menuInfo.getKey();
            int menuQuantity = menuInfo.getValue();

            totalOrderPrice += Menu.getPriceByName(menuName) * menuQuantity;
        }
        return totalOrderPrice;
    }

    public int calculateTotalBenefitPrice(List<Integer> discountDetails, int giftPrice) {
        int totalDiscountPrice = calculateTotalDiscountPrice(discountDetails);
        return totalDiscountPrice + giftPrice;
    }

    private int calculateTotalDiscountPrice(List<Integer> discountDetails) {
        int totalDiscountPrice = 0;
        if (!discountDetails.isEmpty()) {
            for (int discountPrice : discountDetails) {
                totalDiscountPrice += discountPrice;
            }
        }
        return totalDiscountPrice;
    }

    public int calculatePayment(List<Integer> discountDetails) {
        return totalOrderPrice - calculateTotalDiscountPrice(discountDetails);
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
