package model.service;

import java.util.List;
import java.util.Map;
import model.Day;
import model.OrderedMenu;

public class Service {
    private final Day day;
    private final OrderedMenu orderedMenu;
    PosMachine posMachine = new PosMachine();
    EventManager eventManager = new EventManager();

    public Service(String day, String orderedMenu) {
        this.day = new Day(day);
        this.orderedMenu = new OrderedMenu(orderedMenu);
    }

    public Map<String, Integer> getOrderedMenus() {
        return orderedMenu.getOrderedMenu();
    }

    public int getTotalOrderPrice() {
        posMachine.calculateTotalOrderPrice(orderedMenu);
        return posMachine.getTotalOrderPrice();
    }

    public String getGiftName() {
        return eventManager.getGiftName(posMachine.getTotalOrderPrice());
    }

    public List<Integer> getDiscountDetails() {
        return eventManager.checkCustomerCanGetDiscount(day.getDay(), orderedMenu.getOrderedMenu(),
                posMachine.getTotalOrderPrice());
    }

    public int getGiftPrice() {
        return eventManager.getGiftPrice(posMachine.getTotalOrderPrice());
    }

    public String getReservedDayIsWeekdayOrWeekend() {
        return eventManager.checkReservedDayIsWeekendOrWeekday(day.getDay(), orderedMenu.getOrderedMenu());
    }

    public int getTotalBenefitPrice() {
        posMachine.calculateTotalDiscountPrice(day.getDay(), orderedMenu.getOrderedMenu());
        return posMachine.calculateTotalBenefitPrice();
    }

    public int getPayment() {
        return posMachine.calculatePayment();
    }

    public String getBadge() {
        return eventManager.getBadgeName(posMachine.calculateTotalBenefitPrice());
    }
}
