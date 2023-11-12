package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class EventManagerTest {
    @Test
    void checkTotalDiscountInformation() {
        // given
        EventManager eventManager = new EventManager();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        PosMachine posMachine = new PosMachine();
        Menu menu = new Menu();
        // when
        int day = 1;
        posMachine.calculateTotalOrderPrice(orderedMenu, menu);
        int totalOrderPrice = posMachine.getTotalOrderPrice();
        eventManager.checkCustomerCanGetDiscount(day, orderedMenus, totalOrderPrice);
        // given
        assertThat(eventManager.getDiscountDetails()).isEqualTo(List.of(1000, 4046, 0));
    }

    @Test
    void checkCustomerGetGift() {
        // given
        EventManager eventManager = new EventManager();
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        PosMachine posMachine = new PosMachine();
        // when
        posMachine.calculateTotalOrderPrice(orderedMenu, new Menu());
        int totalOrderPrice = posMachine.getTotalOrderPrice();
        // given
        assertThat(eventManager.checkCustomerCanGetGift(totalOrderPrice)).isEqualTo("샴페인");
        assertThat(eventManager.getGiftPrice(new Menu())).isEqualTo(25000);
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
