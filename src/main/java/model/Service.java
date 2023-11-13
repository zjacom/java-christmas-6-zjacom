package model;

import java.util.List;
import java.util.Map;

public class Service {
    PosMachine posMachine = new PosMachine();
    EventManager eventManager = new EventManager();
    private final Day day;
    private final OrderedMenu orderedMenu;

    public Service(String day, String orderedMenu) {
        this.day = new Day(day);
        this.orderedMenu = new OrderedMenu(orderedMenu);
    }

    public Map<String, Integer> getOrderedMenus() {
        return orderedMenu.getOrderedMenu();
    }

    public int getTotalOrderPrice() {
        return posMachine.getTotalOrderPrice();
    }

    public String getGiftName() {
        return eventManager.checkCustomerCanGetGift(posMachine.getTotalOrderPrice());
    }

    public List<Integer> getDiscountDetails() {
        return eventManager.getDiscountDetails();
    }

    public int getGiftPrice() {
        return eventManager.getGiftPrice();
    }

    public int getTotalBenefitPrice(int giftPrice) {
        return posMachine.calculateTotalBenefitPrice(eventManager.getDiscountDetails(), giftPrice);
    }

    public int getPayment() {
        return posMachine.calculatePayment(eventManager.getDiscountDetails());
    }

    public String getBadge(int totalBenefitAmount) {
        return eventManager.getBadge(totalBenefitAmount);
    }

    public int getReservedDay() {
        return day.getDay();
    }
}
