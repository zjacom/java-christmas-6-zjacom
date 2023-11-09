package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class EventManagerTest {
    @Test
    void checkTotalDiscountInformation() {
        // given
        EventManager eventManager = new EventManager();
        OrderServer orderServer = new OrderServer();
        PosMachine posMachine = new PosMachine();
        // when
        int day = 1;
        orderServer.inputStrParseToMap("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        posMachine.calculateTotalOrderAmount(orderServer.getOrderCheck());
        // given
        assertThat(eventManager.getDiscountInfo(day, orderServer, posMachine)).isEqualTo(List.of(1000, 4046, 0));
    }
}
