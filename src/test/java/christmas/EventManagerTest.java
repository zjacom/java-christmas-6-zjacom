package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class EventManagerTest {
    @Test
    void checkTotalDiscountInformation() {
        // given
        EventManager eventManager = new EventManager();
        OrderedMenu orderedMenu = new OrderedMenu();
        PosMachine posMachine = new PosMachine();
        Menu menu = new Menu();
        // when
        int day = 1;
        orderedMenu.inputMenuChangeToOrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        posMachine.calculateTotalOrderAmount(orderedMenu, menu);
        eventManager.collectDiscountInfo(day, orderedMenu, posMachine);
        // given
        assertThat(eventManager.getDiscountInfo()).isEqualTo(List.of(1000, 4046, 0));
    }

    @Test
    void checkCustomerGetGift() {
        // given
        EventManager eventManager = new EventManager();
        OrderedMenu orderedMenu = new OrderedMenu();
        PosMachine posMachine = new PosMachine();
        Menu menu = new Menu();
        // when
        orderedMenu.inputMenuChangeToOrderedMenu("타파스-1,제로콜라-1");
        posMachine.calculateTotalOrderAmount(orderedMenu, menu);
        // given
        assertThat(eventManager.getGiftInfo(posMachine)).isEqualTo(0);
        assertThat(eventManager.queryReceiveGift()).isEqualTo("없음");
    }

    @Test
    void checkBadge() {
        // given
        EventManager eventManager = new EventManager();
        // when
        String badge = eventManager.getBadge(5000);
        // then
        assertThat(badge).isEqualTo("별");
    }
}
