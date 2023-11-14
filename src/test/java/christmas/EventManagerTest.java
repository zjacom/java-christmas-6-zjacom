package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import model.EventManager;
import model.OrderedMenu;
import model.PosMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventManagerTest {
    EventManager eventManager = new EventManager();
    @DisplayName("고객이 10,000원 미만으로 주문했을 때 이벤트에 참여할 수 없다.")
    @Test
    void customerCanNotParticipateEvent() {
        // given
        PosMachine posMachine = new PosMachine();
        int day = 1;
        // when
        OrderedMenu orderedMenu = new OrderedMenu("양송이수프-1");
        posMachine.calculateTotalOrderPrice(orderedMenu);
        int totalOrderPrice = posMachine.getTotalOrderPrice();
        eventManager.checkCustomerCanGetDiscount(day, orderedMenu.getOrderedMenu(), totalOrderPrice);
        // given
        assertThat(eventManager.getDiscountDetails()).isEmpty();
    }

    @DisplayName("고객은 120,000원 이상 주문하면 증정품을 받을 수 있다.")
    @Test
    void customerCanReceiveGift() {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        PosMachine posMachine = new PosMachine();
        // when
        posMachine.calculateTotalOrderPrice(orderedMenu);
        int totalOrderPrice = posMachine.getTotalOrderPrice();
        // given
        assertThat(eventManager.checkCustomerCanGetGift(totalOrderPrice)).isEqualTo("샴페인");
        assertThat(eventManager.getGiftPrice()).isEqualTo(25000);
    }


    @DisplayName("고객의 총 혜택 금액에 따라 배지를 받을 수 있다.")
    @Test
    void customerCanReceiveBadge() {
        // when
        String badge = eventManager.getBadge(5000);
        // then
        assertThat(badge).isEqualTo("별");
    }
}
