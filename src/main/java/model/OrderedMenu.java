package model;

import java.util.HashMap;
import java.util.Map;

public class OrderedMenu {
    // (주문 음식 : 갯수)를 저장하는 필드
    private final Map<String, Integer> orderedMenu;

    // (주문 음식 : 갯수)를 입력 받아 필드에 저장
    public OrderedMenu(String inputValue) {
        this.orderedMenu = parseInputValueToMap(inputValue);
    }

    private Map<String, Integer> parseInputValueToMap(String inputValue) {
        Map<String, Integer> orderedMenus = new HashMap<>();
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            addMenuToOrderedMenu(orderedMenus, pair);
        }
        return orderedMenus;
    }

    private void addMenuToOrderedMenu(Map<String, Integer> orderedMenus, String pair) {
        String[] splitByHyphen = pair.split("-");

        String menuName = splitByHyphen[0];
        int menuQuantity = Integer.parseInt(splitByHyphen[1]);
        orderedMenus.put(menuName, menuQuantity);
    }

    // 주문한 내역 리턴
    public Map<String, Integer> getOrderedMenu() {
        return orderedMenu;
    }
}
