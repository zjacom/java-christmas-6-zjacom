package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import model.OrderedMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedMenuTest {
    @DisplayName("고객이 입력한 주문 형식을 문자열에서 Map으로 바꿨을 때 기대한 값이 나오는지 확인하는 테스트")
    @Test
    void inputValueParseToExpectedMap() {
        // given
        Map<String, Integer> expectedParsedValue = new HashMap<>();
        expectedParsedValue.put("타파스", 1);
        expectedParsedValue.put("제로콜라", 1);
        // when
        OrderedMenu orderedMenu = new OrderedMenu("타파스-1,제로콜라-1");
        Map<String, Integer> parsedValue = orderedMenu.getOrderedMenu();
        // then
        boolean result = parsedValue.equals(expectedParsedValue);
        assertThat(result).isTrue();
    }
}
