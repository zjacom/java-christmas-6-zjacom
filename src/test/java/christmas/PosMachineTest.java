package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import model.OrderedMenu;
import model.service.PosMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PosMachineTest {
    @DisplayName("고객이 주문한 메뉴 이름과 수량을 바탕으로 총 주문 금액을 계산한다.")
    @Test
    void checkExpectedTotalOrderedMenuPrice() {
        // given
        PosMachine posMachine = new PosMachine();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        posMachine.calculateTotalOrderPrice(orderedMenu);
        int totalOrderAmount = posMachine.getTotalOrderPrice();
        // then
        assertThat(totalOrderAmount).isEqualTo(142000);
    }

    @DisplayName("디데이 할인, 주말/평일 할인, 특별 할인, 증정품 가격을 바탕으로 총 혜택 금액을 계산한다.")
    @Test
    void checkExpectedTotalBenefitPrice() {
        // given
        PosMachine posMachine = new PosMachine();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        posMachine.calculateTotalOrderPrice(orderedMenu);
        posMachine.calculateTotalDiscountPrice(3, orderedMenu.getOrderedMenu());
        int totalBenefitAmount = posMachine.calculateTotalBenefitPrice();
        // then
        assertThat(totalBenefitAmount).isEqualTo(-31246);
    }

    @DisplayName("총 주문 금액과 할인 금액을 바탕으로 총 결제 금액을 계산한다.")
    @Test
    void checkExpectedPayment() {
        // given
        PosMachine posMachine = new PosMachine();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        posMachine.calculateTotalOrderPrice(orderedMenu);
        posMachine.calculateTotalDiscountPrice(3, orderedMenu.getOrderedMenu());
        // then
        assertThat(posMachine.calculatePayment()).isEqualTo(135754);

    }
}
