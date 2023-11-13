package model;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final String DAY_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public void validateOrder(String inputValue) {
        validateInputValueConsistsOnlySupportedCharacters(inputValue);
        validateAnythingElse(inputValue);
    }

    private void validateInputValueConsistsOnlySupportedCharacters(String inputValue) {
        if (!inputValue.matches("^[가-힣0-9\\-\\,]+$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateAnythingElse(String inputValue) {
        List<String> orderedMenu = new ArrayList<>();
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            validateInputValueFormat(splitByHyphen);

            String menuName = splitByHyphen[0];
            validateMenuNameDuplicated(orderedMenu, menuName);
            validateMenuNameIncludeInMenu(menuName);

            validateMenuQuantityOverZero(splitByHyphen);
        }
    }

    private void validateMenuQuantityOverZero(String[] splitByHyphen) {
        int menuQuantity = Integer.parseInt(splitByHyphen[1]);

        if (menuQuantity < 1) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private void validateMenuNameIncludeInMenu(String menuName) {
        if (!Menu.getAllOrderedMenuName().contains(menuName)) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private void validateMenuNameDuplicated(List<String> orderedMenu, String menuName) {
        if (orderedMenu.contains(menuName)) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
        orderedMenu.add(menuName);
    }

    private void validateInputValueFormat(String[] splitByHyphen) {
        if (splitByHyphen.length != 2) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
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
