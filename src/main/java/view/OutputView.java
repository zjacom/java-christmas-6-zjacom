package view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    // Map<String, Integer> 형의 데이터를 알맞은 형식으로 변환하여 출력
    public void printMenu(Map<String, Integer> orderedMenu) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();

            result.append(menuName).append(" ").append(quantity).append("개\n");
        }

        System.out.println(result);
    }

    // 가격에 콤마를 넣고 원을 붙혀서 출력
    public void printTotalOrderPrice(int orderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(orderAmount);

        System.out.println(formattedNumber + "원");
    }

    // queryReceiveGift()의 결과 입력받음
    public void printGiftMenu(String giftMenu) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println(giftMenu);
    }

    // 할인 정보 리스트가 비어있으면 없음 출력
    // 할인 정보에 값이 있다면 형식에 맞혀 변환하고 출력
    // 평일 할인인지 주말 할인인지 구분
    public void printDiscountDetails(List<Integer> discountDetails, int giftPrice, String weekdayOrWeekend) {
        System.out.println();
        System.out.println("<혜택 내역>");
        if (discountDetails.isEmpty()) {
            System.out.println("없음");
        }
        if (!discountDetails.isEmpty()) {
            System.out.println("크리스마스 디데이 할인: -" + convertNumber(discountDetails.get(0)) + "원");
            System.out.println("평일 할인: -" + convertNumber(discountDetails.get(1)) + "원");
            System.out.println(weekdayOrWeekend + ": -" + convertNumber(discountDetails.get(2)) + "원");
            System.out.println("증정 이벤트: -" + convertNumber(giftPrice) + "원");
        }
    }

    private String convertNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(amount);
        return formattedNumber;
    }

    // 총 혜택 금액 출력
    public void printTotalBenefitInfo(int totalBenefitAmount) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        if (totalBenefitAmount == 0) {
            System.out.println("0원");
        }
        if (totalBenefitAmount != 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedNumber = decimalFormat.format(totalBenefitAmount);

            System.out.println("-" + formattedNumber + "원");
        }
    }

    // 총 결제 금액 출력
    public void printPayment(int payment) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");

        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(payment);

        System.out.println(formattedNumber + "원");
    }

    // 이벤트 배지 출력
    public void printBadge(String badge) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}