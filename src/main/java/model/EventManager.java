package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventManager {
    private boolean isCustomerCanReceiveGift = false;
    private final String gift = Menu.CHAMPAGNE.getOrderedMenuName();
    private final List<Integer> discountDetails = new ArrayList<>();
    private final String BADGE_SANTA = "산타";
    private final String BADGE_TREE = "트리";
    private final String BADGE_STAR = "별";
    private final String NOTHING = "없음";

    public String checkCustomerCanGetGift(int totalOrderPrice) {
        if (totalOrderPrice >= 120000) {
            isCustomerCanReceiveGift = true;
            return gift;
        }
        return NOTHING;
    }

    public int getGiftPrice() {
        if (isCustomerCanReceiveGift) {
            return Menu.getPriceByName(gift);
        }
        return 0;
    }

    public void checkCustomerCanGetDiscount(int day, Map<String, Integer> orderedMenus, int totalOrderPrice) {
        if (totalOrderPrice >= 10000) {
            addDiscountDetail(day, orderedMenus, new EventCalender());
        }
    }

    private void addDiscountDetail(int day, Map<String, Integer> orderedMenus, EventCalender eventCalender) {
        discountDetails.add(eventCalender.getDdayDiscountPrice(day));
        discountDetails.add(eventCalender.selectWeekdayOrWeekend(day, orderedMenus));
        discountDetails.add(eventCalender.getSpecialDiscountPrice(day));
    }

    public String getBadge(int totalBenefitPrice) {
        if (totalBenefitPrice >= 20000) {
            return BADGE_SANTA;
        }
        if (totalBenefitPrice >= 10000) {
            return BADGE_TREE;
        }
        if(totalBenefitPrice >= 5000) {
            return BADGE_STAR;
        }
        return NOTHING;
    }

    // [디데이 할인 금액, 평일/주말 할인 금액, 스페셜 할인 금액]로 구성된 할인 정보 리턴
    public List<Integer> getDiscountDetails() {
        return discountDetails;
    }
}
