package model;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public void validateOrder(String inputValue) {
        validateInputValueConsistsOnlySupportedCharacters(inputValue);
        validateFormat(inputValue);
        validateDuplicated(inputValue);
        validateQuantity(inputValue);
        validateMenuNameInMenu(inputValue);
    }

    private void validateInputValueConsistsOnlySupportedCharacters(String inputValue) {
        if (!inputValue.matches("^[가-힣0-9\\-\\,]+$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateFormat(String inputValue) {
        // 구분에 String 배열을 사용하는데, 이 방법이 제일 빠른 방법인지 확인 필요.
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");

            if (splitByHyphen.length != 2) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void validateDuplicated(String inputValue) {
        List<String> orderedMenu = new ArrayList<>();
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");

            String menuName = splitByHyphen[0];
            if (orderedMenu.contains(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            orderedMenu.add(menuName);
        }
    }

    private void validateQuantity(String inputValue) {
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");
            int menuQuantity = Integer.parseInt(splitByHyphen[1]);

            if (menuQuantity < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }


    private void validateMenuNameInMenu(String inputValue) {
        String[] splitByComma = inputValue.split(",");

        for (String pair : splitByComma) {
            String[] splitByHyphen = pair.split("-");

            String menuName = splitByHyphen[0];

            if (!Menu.getOrderedMenuNames().contains(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void validateDay(String inputValue) {
        validateInputValueConsistOnlyDigits(inputValue);
        validateDayInCorrectRange(inputValue);
    }

    private void validateDayInCorrectRange(String inputValue) {
        int day = Integer.parseInt(inputValue);
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateInputValueConsistOnlyDigits(String inputValue) {
        if (!inputValue.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}