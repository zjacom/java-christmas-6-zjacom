package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class PosMachineTest {
    @Test
    void checkExpectedTotalOrderAmount() {
        // given
        PosMachine posMachine = new PosMachine();
        Parser parser = new Parser();
        Map<String, Integer> orderInfo = parser.inputStrParseToMap("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        int totalOrderAmount = posMachine.calculateTotalOrderAmount(orderInfo);
        // then
        assertThat(totalOrderAmount).isEqualTo(142000);
    }
}
