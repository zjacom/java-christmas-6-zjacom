package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PosMachineTest {
    @Test
    void checkExpectedTotalOrderAmount() {
        // given
        PosMachine posMachine = new PosMachine();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Menu menu = new Menu();
        // when
        int totalOrderAmount = posMachine.calculateTotalOrderAmount(orderedMenu, menu);
        // then
        assertThat(totalOrderAmount).isEqualTo(142000);
    }

    @Test
    void checkExpectedTotalBenefitAmount() {
        // given
        PosMachine posMachine = new PosMachine();
        // when
        int totalBenefitAmount = posMachine.calculateTotalBenefitAmount(List.of(1000, 2000, 3000), 25000);
        // then
        assertThat(totalBenefitAmount).isEqualTo(31000);
    }

    @Test
    void checkExpectedPayment() {
        // given
        PosMachine posMachine = new PosMachine();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        posMachine.calculateTotalOrderAmount(orderedMenu, new Menu());
        int payment = posMachine.calculatePayment(List.of(1000, 2000, 3000));
        // then
        assertThat(payment).isEqualTo(136000);

    }
}
