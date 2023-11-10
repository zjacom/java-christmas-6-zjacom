package christmas;

import java.util.Map;

public class OrderedMenu {
    // (주문 음식 : 갯수)를 저장하는 필드
    private final Map<String, Integer> orderedMenu;

    // (주문 음식 : 갯수)를 입력 받아 필드에 저장
    public OrderedMenu(Map<String, Integer> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }

    // 주문한 내역 리턴
    public Map<String, Integer> getOrderedMenu() {
        return orderedMenu;
    }
}
