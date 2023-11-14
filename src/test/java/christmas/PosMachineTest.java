package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.OrderedMenu;
import model.PosMachine;
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
        int totalOrderAmount = posMachine.calculateTotalOrderPrice(orderedMenu);
        // then
        assertThat(totalOrderAmount).isEqualTo(142000);
    }

    @DisplayName("디데이 할인, 주말/평일 할인, 특별 할인, 증정품 가격을 바탕으로 총 혜택 금액을 계산한다.")
    @Test
    void checkExpectedTotalBenefitPrice() {
        // given
        PosMachine posMachine = new PosMachine();
        // when
        int totalBenefitAmount = posMachine.calculateTotalBenefitPrice(List.of(-1000, -2046, -1000), -25000);
        // then
        assertThat(totalBenefitAmount).isEqualTo(-29046);
    }

    @DisplayName("총 주문 금액과 할인 금액을 바탕으로 총 결제 금액을 계산한다.")
    @Test
    void checkExpectedPayment() {
        // given
        PosMachine posMachine = new PosMachine();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        posMachine.calculateTotalOrderPrice(orderedMenu);
        int payment = posMachine.calculatePayment(List.of(-1000, -2046, -1000));
        // then
        assertThat(payment).isEqualTo(137954);

    }
}
