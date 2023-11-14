package model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Badge;
import model.Discount;
import model.Gift;
import model.Menu;

public class EventManager {
    Discount discount = new Discount();
    Gift gift = new Gift();
    Badge badge = new Badge();

    public List<Integer> checkCustomerCanGetDiscount(int day, Map<String, Integer> orderedMenus, int totalOrderPrice) {
        if (totalOrderPrice >= 10000) {
            return addDiscountDetail(day, orderedMenus);
        }
        return List.of();
    }

    private List<Integer> addDiscountDetail(int day, Map<String, Integer> orderedMenus) {
        List<Integer> discountDetails = new ArrayList<>();
        discountDetails.add(discount.getDdayDiscountPrice(day));
        discountDetails.add(discount.getWeekendOrWeekdayDiscountPrice(day, orderedMenus).get(1));
        discountDetails.add(discount.getSpecialDiscountPrice(day));
        return discountDetails;
    }

    public String checkReservedDayIsWeekendOrWeekday(int day, Map<String, Integer> orderedMenus) {
        if (discount.getWeekendOrWeekdayDiscountPrice(day, orderedMenus).get(0) == 0) {
            return "주말 할인";
        }
        return "평일 할인";
    }

    public int getGiftPrice(int totalOrderPrice) {
        if (isCustomerCanGetReceiveGift(getGiftName(totalOrderPrice))) {
            return -Menu.getPriceByName(getGiftName((totalOrderPrice)));
        }
        return 0;
    }

    public String getGiftName(int totalOrderPrice) {
        return gift.checkCustomerCanGetGift(totalOrderPrice);
    }

    private boolean isCustomerCanGetReceiveGift(String giftName) {
        if (giftName.equals(Menu.CHAMPAGNE.getOrderedMenuName())) {
            return true;
        }
        return false;
    }

    public String getBadgeName(int totalBenefitPrice) {
        return badge.getBadge(totalBenefitPrice);
    }
}
