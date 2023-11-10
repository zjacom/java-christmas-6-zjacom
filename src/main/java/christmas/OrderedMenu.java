package christmas;

import java.util.HashMap;
import java.util.Map;

public class OrderedMenu {
    // (주문 음식 : 갯수)를 저장하는 필드
    Map<String, Integer> orderedMenu = new HashMap<>();
    
    // (주문 음식 : 갯수) 형태로 반환
    // 구분에 String 배열을 사용하는데, 이 방법이 제일 빠른 방법인지 확인 필요.
    public void inputMenuChangeToOrderedMenu(String inputValue) {
        Map<String, Integer> parsedValue = new HashMap<>();

        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");

            if (splitByHyphen.length == 2) {
                String menuName = splitByHyphen[0];
                int menuQuantity = Integer.parseInt(splitByHyphen[1]);

                parsedValue.put(menuName, menuQuantity);
            }
        }
        this.orderedMenu = parsedValue;
    }

    public Map<String, Integer> getOrderedMenu() {
        return orderedMenu;
    }
}
