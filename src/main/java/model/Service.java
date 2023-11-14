package model;

import java.util.List;
import java.util.Map;

public class Service {
    PosMachine posMachine = new PosMachine();
    EventManager eventManager = new EventManager();
    EventCalender eventCalender = new EventCalender();
    private final Day day;
    private final OrderedMenu orderedMenu;

    public Service(String day, String orderedMenu) {
        this.day = new Day(day);
        this.orderedMenu = new OrderedMenu(orderedMenu);
    }

    public void serviceLogic() {
        posMachine.calculateTotalOrderPrice(orderedMenu);
        eventManager.checkCustomerCanGetDiscount(day.getDay(), orderedMenu.getOrderedMenu(),
                posMachine.getTotalOrderPrice());
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

    public String getReservedDayIsWeekdayOrWeekend() {
        return eventCalender.checkReservedDayIsWeekdayOrWeekend(day.getDay());
    }

    public int getTotalBenefitPrice() {
        return posMachine.calculateTotalBenefitPrice(eventManager.getDiscountDetails(), eventManager.getGiftPrice());
    }

    public int getPayment() {
        return posMachine.calculatePayment(eventManager.getDiscountDetails());
    }

    public String getBadge() {
        return eventManager.getBadge(posMachine.calculateTotalBenefitPrice(eventManager.getDiscountDetails(),
                eventManager.getGiftPrice()));
    }
}
