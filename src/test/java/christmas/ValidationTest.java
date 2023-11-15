package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    Validation validation = new Validation();
    @DisplayName("입력된 값이 한글, 숫자, 하이픈, 콤마로만 구성됐는지 확인한다.")
    @Test
    void inputOrderContainOnlyHanguelAndDigitAndHyphenAndComma() {
        // when
        String inputOrder = "티본스테이크=1,바비큐립=1,초코케이크=2,제로콜라=1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("입력된 값이 하이픈을 기준으로 형식에 맞게 입력됐는지 확인한다.")
    @Test
    void inputOrderSplitByMenuNameAndQuantityBasedOnHyphen() {
        // when
        String inputOrder = "티본스테이크-1-2,바비큐립-1-3,초코케이크-2-4,제로콜라-1-5";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("입력된 메뉴의 이름이 메뉴판에 있는지 확인한다.")
    @Test
    void menuNameIncludedInMenu() {
        // when
        String inputOrder = "라면-1,김밥-1,초코케이크-2,제로콜라-1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("입력된 메뉴의 수량이 적어도 1보다 큰 값인지 확인한다.")
    @Test
    void menuQuantityIsOverOne() {
        // when
        String inputOrder = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-0";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("입력된 메뉴의 이름이 중복된 값인지 확인한다.")
    @Test
    void menuNameDuplicated() {
        // when
        String inputOrder = "티본스테이크-1,초코케이크-1,초코케이크-2,제로콜라-1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("입력된 메뉴가 오직 음료만 있는지 확인한다.")
    @Test
    void customerInputOrderMenuOnlyBeverage() {
        // when
        String inputDate = "레드와인-1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

    @DisplayName("입력된 주문 메뉴의 개수가 20개를 넘는지 확인한다.")
    @Test
    void customerInputOverTotalQuantity() {
        // when
        String inputDate = "초코케이크-21";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n"
                        + "(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)");
    }

    @DisplayName("입력된 날짜의 값이 숫자인지 확인한다.")
    @Test
    void inputDateOnlyDigit() {
        // when
        String inputDate = "a";
        // then
        assertThatThrownBy(() -> validation.validateDay(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
    @DisplayName("입력된 날짜의 값이 12월달안에 존재하는 날인지 확인한다.")
    @Test
    void inputDateHasNumberRange() {
        // when
        String inputDate = "99";
        // then
        assertThatThrownBy(() -> validation.validateDay(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
