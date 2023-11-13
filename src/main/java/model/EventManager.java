package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventManager {
    // 할인정보를 필드로 가진다.
    private boolean isCustomerCanReceiveGift = false;
    private final String gift = Menu.CHAMPAGNE.getName();
    private final List<Integer> discountDetails = new ArrayList<>();

    // 총 주문 금액을 입력받아 증정품을 증정할 수 있는지 판단하고 증정할 수 있다면 해당 가격을 리턴
    public String checkCustomerCanGetGift(int totalOrderPrice) {
        if (totalOrderPrice >= 120000) {
            isCustomerCanReceiveGift = true;
            return gift;
        }
        return "없음";
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
            return "산타";
        }
        if (totalBenefitPrice >= 10000) {
            return "트리";
        }
        if(totalBenefitPrice >= 5000) {
            return "별";
        }
        return "없음";
    }

    // [x, y, z]로 구성된 할인 정보 리턴
    public List<Integer> getDiscountDetails() {
        return discountDetails;
    }
}
