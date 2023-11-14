package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import model.EventCalender;
import model.OrderedMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventCalenderTest {
    EventCalender eventCalender = new EventCalender();

    @DisplayName("고객이 디데이 이벤트 기간에 주문하면 디데이 할인을 받을 수 있다.")
    @Test
    void customerReserveInsideOfDdayEventPeriod() {
        // given
        int day = 3;
        // when
        int dDayDiscountAmount = eventCalender.getDdayDiscountPrice(day);
        // then
        assertThat(dDayDiscountAmount).isEqualTo(-1200);
    }

    @DisplayName("고객이 디데이 이벤트 기간이 아닐 때 주문하면 디데이 할인을 받지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28, 29, 30, 31})
    void customerReserveOutsideOfDdayEventPeriod(int day) {
        // when
        int dDayDiscountAmount = eventCalender.getDdayDiscountPrice(day);
        // then
        assertThat(dDayDiscountAmount).isEqualTo(0);
    }

    @DisplayName("고객이 평일인데 디저트 메뉴를 주문하면 할인을 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void customerOrderIncludeDessertMenuInWeekday(int day) {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        int weekdayDiscountAmount = eventCalender.getWeekendOrWeekdayDiscountPrice(day, orderedMenu.getOrderedMenu());
        // then
        assertThat(weekdayDiscountAmount).isEqualTo(-4046);
    }

    @DisplayName("고객이 평일인데 디저트 메뉴를 주문하지 않으면 할인을 받을 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void customerOrderExceptDessertMenuInWeekday(int day) {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,제로콜라-1");
        // when
        int weekdayDiscountAmount = eventCalender.getWeekendOrWeekdayDiscountPrice(day, orderedMenu.getOrderedMenu());
        // then
        assertThat(weekdayDiscountAmount).isEqualTo(0);
    }

    @DisplayName("고객이 주말인데 메인 메뉴를 주문하면 할인을 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void customerOrderIncludeMainMenuInWeekend(int day) {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        // when
        int weekendDiscountAmount = eventCalender.getWeekendOrWeekdayDiscountPrice(day, orderedMenu.getOrderedMenu());
        // then
        assertThat(weekendDiscountAmount).isEqualTo(-4046);
    }

    @DisplayName("고객이 주말이지만 메인 메뉴를 주문하지 않으면 할인을 받을 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void customerOrderExceptMainMenuInWeekend(int day) {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("양송이수프-1,초코케이크-2,제로콜라-1");
        // when
        int weekendDiscountAmount = eventCalender.getWeekendOrWeekdayDiscountPrice(day, orderedMenu.getOrderedMenu());
        // then
        assertThat(weekendDiscountAmount).isEqualTo(0);
    }

    @DisplayName("고객이 스페셜 할인 기간에 주문하면 전체 주문 금액에서 1000원을 할인 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void customerReservedInsideOfSpecialEventPeriod(int day) {
        // when
        int specialDiscountAmount = eventCalender.getSpecialDiscountPrice(day);
        // then
        assertThat(specialDiscountAmount).isEqualTo(-1000);
    }

    // 수정
    @DisplayName("날짜를 입력 받아서 주말인지 평일인지 확인하는 테스트")
    @Test
    void checkReservedDayIsWeekdayOrWeekend() {
        // given
        int day = 13;
        // when
        String weekday = eventCalender.checkReservedDayIsWeekdayOrWeekend(day);
        // then
        assertThat(weekday).isEqualTo("평일 할인");
    }
}
