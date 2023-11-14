package model.service;

import java.util.List;
import java.util.Map;
import model.Menu;
import model.OrderedMenu;

public class PosMachine {
    EventManager eventManager = new EventManager();
    private int totalOrderPrice = 0;
    private int totalDiscountPrice = 0;

    public void calculateTotalOrderPrice(OrderedMenu orderedMenu) {
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        for (Map.Entry<String, Integer> menuInfo : orderedMenus.entrySet()) {
            String menuName = menuInfo.getKey();
            int menuQuantity = menuInfo.getValue();

            this.totalOrderPrice += Menu.getPriceByName(menuName) * menuQuantity;
        }
    }

    public int calculateTotalBenefitPrice() {
        return totalDiscountPrice + eventManager.getGiftPrice(totalOrderPrice);
    }

    public int calculatePayment() {
        return totalOrderPrice + totalDiscountPrice;
    }

    public void calculateTotalDiscountPrice(int day, Map<String, Integer> orderedMenu) {
        List<Integer> discount = eventManager.checkCustomerCanGetDiscount(day, orderedMenu, totalOrderPrice);
        if (!discount.isEmpty()) {
            for (int discountPrice : discount) {
                this.totalDiscountPrice += discountPrice;
            }
        }
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
}

