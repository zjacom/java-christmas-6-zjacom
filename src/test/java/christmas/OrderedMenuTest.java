package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import model.OrderedMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedMenuTest {
    @DisplayName("고객이 주문 메뉴와 갯수를 입력하면 Map 형태로 파싱된다.")
    @Test
    void inputOrderMenuParsingToMap() {
        // given
        Map<String, Integer> expectedParsedValue = new HashMap<>();
        expectedParsedValue.put("타파스", 1);
        expectedParsedValue.put("제로콜라", 1);
        OrderedMenu orderedMenu = new OrderedMenu("타파스-1,제로콜라-1");
        // when
        Map<String, Integer> parsedValue = orderedMenu.getOrderedMenu();
        boolean result = parsedValue.equals(expectedParsedValue);
        // then
        assertThat(result).isTrue();
    }
}
