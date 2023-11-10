package christmas;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    // 할인정보를 필드로 가진다.
    private boolean receiveGift = false;
    private final String gift = "샴페인";
    private final String noGift = "없음";
    private List<Integer> discountInfo = new ArrayList<>();

    // 총주문금액을 입력받아 샴페인을 증정할 수 있는지 판단
    public int getGiftInfo(PosMachine posMachine, Menu menu) {
        if (posMachine.getTotalOrderAmount() >= 120000) {
            receiveGift = true;
            return menu.findMenuPrice(gift);
        }
        return 0;
    }

    public String queryReceiveGift() {
        if (receiveGift) {
            return gift + " 1개";
        }
        return noGift;
    }

    // 날짜, 주문 정보, 총 주문 금액을 입력받아서 [디데이 할인, 평일 할인, 특별 할인]을 리턴
    public void collectDiscountInfo(int day, OrderedMenu orderedMenu, PosMachine posMachine) {
        EventCalender eventCalender = new EventCalender();
        if (posMachine.getTotalOrderAmount() >= 10000) {
            discountInfo.add(eventCalender.getDdayDiscountAmount(day));
            discountInfo.add(eventCalender.selectWeekdayOrWeekend(day, orderedMenu));
            discountInfo.add(eventCalender.getSpecialDiscountAmount(day));
        }
    }

    // 총혜택금액을 입력 받아서 받을 수 있는 배지 리턴
    public String getBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= 20000) {
            return "산타";
        }
        if (totalBenefitAmount >= 10000) {
            return "트리";
        }
        if(totalBenefitAmount >= 5000) {
            return "별";
        }
        return "없음";
    }

    public List<Integer> getDiscountInfo() {
        return discountInfo;
    }
}
