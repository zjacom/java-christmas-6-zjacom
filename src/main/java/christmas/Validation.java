package christmas;

import java.util.HashMap;
import java.util.Map;

public class Validation {
    public Map<String, Integer> validateOrder(String inputValue) {
        Menu menu = new Menu();
        // 문자열에 문자, 숫자, 하이픈, 콤마만 있는지 확인
        if (!inputValue.matches("^[가-힣0-9\\-\\,]+$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        // 하이픈으로 구분한 문자열이 이름:개수로 되어있는지 확인
        Map<String, Integer> orderedMenus = validateSome(inputValue);

        for (String orderedMenuName : orderedMenus.keySet()) {
            if (!menu.getMenu().keySet().contains(orderedMenuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        for (int orderedMenuQuantity : orderedMenus.values()) {
            if (orderedMenuQuantity == 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }

        return orderedMenus;
    }

    private Map<String, Integer> validateSome(String inputValue) {
        Map<String, Integer> orderedMenus = new HashMap<>();
        // 구분에 String 배열을 사용하는데, 이 방법이 제일 빠른 방법인지 확인 필요.
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");

            if (splitByHyphen.length != 2) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            String menuName = splitByHyphen[0];
            if (orderedMenus.keySet().contains(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            int menuQuantity = Integer.parseInt(splitByHyphen[1]);

            orderedMenus.put(menuName, menuQuantity);
        }
        return orderedMenus;
    }

    public int validateDay(String inputValue) {
        if (!inputValue.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        int day = Integer.parseInt(inputValue);
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        return day;
    }
}
