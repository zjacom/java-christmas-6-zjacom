package christmas;

import java.util.List;
import java.util.Map;

public class PosMachine {
    Menu menu = new Menu();
    private int totalOrderAmount = 0;

    // (음식 이름, 개수)을 입력 받아서 총 주문 금액 계산
    public int calculateTotalOrderAmount(Map<String, Integer> orderInfos) {
        for (Map.Entry<String, Integer> orderInfo : orderInfos.entrySet()) {
            String menuName = orderInfo.getKey();
            int menuQuantity = orderInfo.getValue();

            totalOrderAmount += menu.findMenuPrice(menuName) * menuQuantity;
        }
        return totalOrderAmount;
    }

    // 할인정보와 증정품 가격을 입력받아 총혜택금액 계산
    public int 총혜택금액_계산(List<Integer> 할인정보, int 증정품가격) {
        return 0;
    }

    // 총주문 금액과 할인 정보를 입력받아서 예상결제금액 리턴
    public int 예상결제금액_계산(List<Integer> 할인정보) {
        return 0;
    }
}
