package christmas;

import java.util.Map;

public class OrderedMenu {
    // (주문 음식 : 갯수)를 저장하는 필드
    private final Map<String, Integer> orderedMenu;

    // (주문 음식 : 갯수)를 입력받음
    public OrderedMenu(Map<String, Integer> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }

    public Map<String, Integer> getOrderedMenu() {
        return orderedMenu;
    }
}
