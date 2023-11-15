package view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import model.Menu;

public class OutputView {
    public void printOrderedMenu(Map<String, Integer> orderedMenu) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String menuName = entry.getKey();
            int menuQuantity = entry.getValue();
            result.append(menuName).append(" ").append(menuQuantity).append("개\n");
        }
        System.out.println(result);
    }

    public void printTotalOrderPrice(int orderPrice) {
        System.out.println("<할인 전 총주문 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(orderPrice);
        System.out.println(formattedNumber + "원");
    }

    public void printGiftName(String giftName) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (giftName.equals("없음")) {
            System.out.println(giftName);
        }
        if (giftName.equals(Menu.CHAMPAGNE.getOrderedMenuName())) {
            System.out.println(giftName + " 1개");
        }
    }

    public void printDiscountDetails(List<Integer> discountDetails, int giftPrice, String weekdayOrWeekend) {
        System.out.println();
        System.out.println("<혜택 내역>");
        if (discountDetails.isEmpty()) {
            System.out.println("없음");
        }
        if (!discountDetails.isEmpty()) {
            printChristmasDiscount(discountDetails);
            printWeekendOrWeekdayDiscount(discountDetails, weekdayOrWeekend);
            printSpecialDiscount(discountDetails);
            printGiftDiscount(giftPrice);
        }
    }

    private void printGiftDiscount(int giftPrice) {
        if (giftPrice != 0) {
            System.out.println("증정 이벤트: " + formattingDiscountPrice(giftPrice) + "원");
        }
    }

    private void printSpecialDiscount(List<Integer> discountDetails) {
        if (discountDetails.get(2) != 0) {
            System.out.println("특별 할인: " + formattingDiscountPrice(discountDetails.get(2)) + "원");
        }
    }

    private void printWeekendOrWeekdayDiscount(List<Integer> discountDetails, String weekdayOrWeekend) {
        if (discountDetails.get(1) != 0) {
            System.out.println(weekdayOrWeekend + ": " + formattingDiscountPrice(discountDetails.get(1)) + "원");
        }
    }

    private void printChristmasDiscount(List<Integer> discountDetails) {
        if (discountDetails.get(0) != 0) {
            System.out.println("크리스마스 디데이 할인: " + formattingDiscountPrice(discountDetails.get(0)) + "원");
        }
    }

    private String formattingDiscountPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }

    public void printTotalBenefitPrice(int totalBenefitPrice) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        if (totalBenefitPrice == 0) {
            System.out.println("0원");
        }
        if (totalBenefitPrice != 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedNumber = decimalFormat.format(totalBenefitPrice);
            System.out.println(formattedNumber + "원");
        }
    }

    public void printPayment(int payment) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(payment);
        System.out.println(formattedNumber + "원");
    }

    public void printBadge(String badge) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}