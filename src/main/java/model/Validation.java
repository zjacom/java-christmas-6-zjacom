package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final String ORDER_ONLY_DRINK_ERROR_MESSAGE = "[ERROR] 음료만 주문 시, 주문할 수 없습니다.";
    private final String ORDER_OVER_QUANTITY_ERROR_MESSAGE = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n"
            + "(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)";
    private final String DAY_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public void validateOrder(String inputValue) {
        validateInputValueConsistsOnlySupportedCharacters(inputValue);
        validateInputValueFormat(inputValue);
        validateMenuNameIncludeInMenu(inputValue);
        validateMenuQuantityOverZero(inputValue);
        validateMenuNameDuplicated(inputValue);
        validateInputValueOnlyDrink(inputValue);
        validateOrderedMenuTotalQuantity(inputValue);
    }

    private void validateInputValueConsistsOnlySupportedCharacters(String inputValue) {
        if (!inputValue.matches("^[가-힣0-9\\-\\,]+$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateMenuQuantityOverZero(String inputValue) {
        String[] splitByComma = inputValue.split(",");
        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            int menuQuantity = Integer.parseInt(splitByHyphen[1]);

            if (menuQuantity < 1) {
                throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
            }
        }
    }

    private void validateMenuNameIncludeInMenu(String inputValue) {
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            String menuName = splitByHyphen[0];

            if (!Menu.getAllOrderedMenuName().contains(menuName)) {
                throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
            }
        }
    }

    private void validateMenuNameDuplicated(String inputValue) {
        List<String> orderedMenu = new ArrayList<>();
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            String menuName = splitByHyphen[0];

            if (orderedMenu.contains(menuName)) {
                throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
            }
            orderedMenu.add(menuName);
        }
    }

    private void validateInputValueFormat(String inputValue) {
        String[] splitByComma = inputValue.split(",");
        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");

            if (splitByHyphen.length != 2) {
                throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
            }
        }
    }

    private void validateInputValueOnlyDrink(String inputValue) {
        Set<String> orderedMenu = new HashSet<>();
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            String menuName = splitByHyphen[0];
            orderedMenu.add(menuName);
        }
        if (isOrderedMenuContainOnlyDrink(orderedMenu)) {
            throw new IllegalArgumentException(ORDER_ONLY_DRINK_ERROR_MESSAGE);
        }
    }

    private boolean isOrderedMenuContainOnlyDrink(Set<String> orderedMenu) {
        return Set.of(Menu.CHAMPAGNE.getOrderedMenuName(), Menu.RED_WINE.getOrderedMenuName(),
                Menu.ZERO_COLA.getOrderedMenuName()).containsAll(orderedMenu);
    }


    private void validateOrderedMenuTotalQuantity(String inputValue) {
        String[] splitByComma = inputValue.split(",");
        int totalQuantity = 0;
        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            totalQuantity += Integer.parseInt(splitByHyphen[1]);
        }
        if (totalQuantity > 20) {
            throw new IllegalArgumentException(ORDER_OVER_QUANTITY_ERROR_MESSAGE);
        }
    }

    public void validateDay(String inputValue) {
        validateInputValueConsistOnlyDigits(inputValue);
        validateDayInCorrectRange(inputValue);
    }

    private void validateDayInCorrectRange(String inputValue) {
        int day = Integer.parseInt(inputValue);
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        }
    }

    private void validateInputValueConsistOnlyDigits(String inputValue) {
        if (!inputValue.matches("^\\d+$")) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        }
    }
}
