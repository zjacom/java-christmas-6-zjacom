package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventManager {
    // 할인정보를 필드로 가진다.
    private boolean isCustomerCanReceiveGift = false;
    private final String gift = Menu.CHAMPAGNE.getOrderedMenuName();
    private final List<Integer> discountDetails = new ArrayList<>();
    private final String BADGE_SANTA = "산타";
    private final String BADGE_TREE = "트리";
    private final String BADGE_STAR = "별";
    private final String NOTHING = "없음";

    // 총 주문 금액을 입력받아 증정품을 증정할 수 있는지 판단하고 증정할 수 있다면 해당 가격을 리턴
    public String checkCustomerCanGetGift(int totalOrderPrice) {
        if (totalOrderPrice >= 120000) {
            isCustomerCanReceiveGift = true;
            return gift;
        }
        return NOTHING;
    }

    // 어떤 증정품을 증정할 수 있는지 리턴
    public int getGiftPrice() {
        if (isCustomerCanReceiveGift) {
            return Menu.getPriceByName(gift);
        }
        return 0;
    }

    // 날짜, 주문 정보, 총 주문 금액을 입력받아서 [디데이 할인, 평일 할인, 특별 할인]을 리턴
    public void checkCustomerCanGetDiscount(int day, Map<String, Integer> orderedMenus, int totalOrderPrice) {
        if (totalOrderPrice >= 10000) {
            addDiscountDetail(day, orderedMenus, new EventCalender());
        }
    }

    private void addDiscountDetail(int day, Map<String, Integer> orderedMenus, EventCalender eventCalender) {
        discountDetails.add(eventCalender.getDdayDiscountPrice(day));
        discountDetails.add(eventCalender.selectWeekdayOrWeekend(day, orderedMenus));
        discountDetails.add(eventCalender.getSpecialDiscountAmount(day));
    }

    // 총혜택금액을 입력 받아서 받을 수 있는 배지 리턴
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

    // [x, y, z]로 구성된 할인 정보 리턴
    public List<Integer> getDiscountDetails() {
        return discountDetails;
    }
}
