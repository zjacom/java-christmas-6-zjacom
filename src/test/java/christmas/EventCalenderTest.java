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

    @DisplayName("날짜를 입력 받아서 D-day 할인이 잘 적용되는지 테스트")
    @Test
    void checkDdayDiscountPrice() {
        // given
        EventCalender eventCalender = new EventCalender();
        // when
        int day = 3;
        int dDayDiscountAmount = eventCalender.getDdayDiscountPrice(day);
        // then
        assertThat(dDayDiscountAmount).isEqualTo(1200);
    }

    @DisplayName("평일 할인 혜택이 알맞게 들어가는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void checkWeekdayDiscountPrice(int day) {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        // when
        int weekdayDiscountAmount = eventCalender.getWeekendOrWeekdayDiscountPrice(day, orderedMenus);
        // then
        assertThat(weekdayDiscountAmount).isEqualTo(4046);
    }

    @DisplayName("주말 할인 혜택이 알맞게 들어가는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void checkWeekendDiscountPrice(int day) {
        // given
        OrderedMenu orderedMenu = new OrderedMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        // when
        int weekendDiscountAmount = eventCalender.getWeekendOrWeekdayDiscountPrice(day, orderedMenus);
        // then
        assertThat(weekendDiscountAmount).isEqualTo(4046);
    }

    @DisplayName("스페셜 할인이 알맞게 들어가는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void checkSpecialDiscountPrice(int day) {
        // when
        int specialDiscountAmount = eventCalender.getSpecialDiscountPrice(day);
        // then
        assertThat(specialDiscountAmount).isEqualTo(1000);
    }

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
