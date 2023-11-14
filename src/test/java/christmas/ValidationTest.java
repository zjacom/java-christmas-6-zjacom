package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.Validation;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void inputOrderContainOnlyHanguelAndDigitAndHyphenAndComma() {
        // given
        Validation validation = new Validation();
        // when
        String inputOrder = "티본스테이크=1,바비큐립=1,초코케이크=2,제로콜라=1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void inputOrderSplitByMenuNameAndQuantityBasedOnHyphen() {
        // given
        Validation validation = new Validation();
        // when
        String inputOrder = "티본스테이크-1-2,바비큐립-1-3,초코케이크-2-4,제로콜라-1-5";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void menuNameIncludedInMenu() {
        // given
        Validation validation = new Validation();
        // when
        String inputOrder = "라면-1,김밥-1,초코케이크-2,제로콜라-1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void menuQuantityIsOverOne() {
        // given
        Validation validation = new Validation();
        // when
        String inputOrder = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-0";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void menuNameDuplicated() {
        // given
        Validation validation = new Validation();
        // when
        String inputOrder = "티본스테이크-1,초코케이크-1,초코케이크-2,제로콜라-1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void customerInputOrderMenuOnlyDrink() {
        // given
        Validation validation = new Validation();
        // when
        String inputDate = "레드와인-1";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

    @Test
    void customerInputOverTotalQuantity() {
        // given
        Validation validation = new Validation();
        // when
        String inputDate = "초코케이크-21";
        // then
        assertThatThrownBy(() -> validation.validateOrder(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.\n"
                        + "(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)");
    }

    @Test
    void inputDateOnlyDigit() {
        // given
        Validation validation = new Validation();
        // when
        String inputDate = "a";
        // then
        assertThatThrownBy(() -> validation.validateDay(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
    @Test
    void inputDateHasNumberRange() {
        // given
        Validation validation = new Validation();
        // when
        String inputDate = "99";
        // then
        assertThatThrownBy(() -> validation.validateDay(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    // 음료만 주문했을 경우와 총 주문 수량이 20개 넘었을 때 예외 발생 추가
}
