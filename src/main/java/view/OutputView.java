package view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printOrderedMenu(Map<String, Integer> orderedMenu) {
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

    public void printGiftMenu(String giftMenu) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println(giftMenu);
    }

    public void printDiscountDetails(List<Integer> discountDetails, int giftPrice, String weekdayOrWeekend) {
        System.out.println();
        System.out.println("<혜택 내역>");
        if (discountDetails.isEmpty()) {
            System.out.println("없음");
        }
        if (!discountDetails.isEmpty()) {
            if (discountDetails.get(0) != 0) {
                System.out.println("크리스마스 디데이 할인: " + formattingDiscountPrice(discountDetails.get(0)) + "원");
            }
            if (discountDetails.get(0) == 0) {
                System.out.println("크리스마스 디데이 할인: 0원");
            }
            if (discountDetails.get(1) != 0) {
                System.out.println(weekdayOrWeekend + ": " + formattingDiscountPrice(discountDetails.get(1)) + "원");
            }
            if (discountDetails.get(1) == 0) {
                System.out.println(weekdayOrWeekend + ": 0원");
            }
            if (discountDetails.get(2) != 0) {
                System.out.println("특별 할인: " + formattingDiscountPrice(discountDetails.get(2)) + "원");
            }
            if (discountDetails.get(2) == 0) {
                System.out.println("특별 할인: 0원");
            }
            if (giftPrice != 0) {
                System.out.println("증정 이벤트: " + formattingDiscountPrice(giftPrice) + "원");
            }
            if (giftPrice == 0) {
                System.out.println("증정 이벤트: 0원");
            }
        }
    }

    private String formattingDiscountPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }

    public void printTotalBenefitInfo(int totalBenefitPrice) {
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