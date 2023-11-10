package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventCalenderTest {
    EventCalender eventCalender = new EventCalender();

    @DisplayName("날짜를 입력 받아서 D-day 할인이 잘 적용되는지 테스트")
    @Test
    void checkDdayDiscountAmount() {
        // given
        EventCalender eventCalender = new EventCalender();
        // when
        int day = 3;
        int dDayDiscountAmount = eventCalender.getDdayDiscountAmount(day);
        // then
        assertThat(dDayDiscountAmount).isEqualTo(1200);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void checkWeekdayDiscountAmount(int day) {
        // given
        Validation validation = new Validation();
        OrderedMenu orderedMenu = new OrderedMenu(validation.validateOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"));
        // when
        int weekdayDiscountAmount = eventCalender.selectWeekdayOrWeekend(day, orderedMenu);
        // then
        assertThat(weekdayDiscountAmount).isEqualTo(4046);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void checkWeekendDiscountAmount(int day) {
        // given
        Validation validation = new Validation();
        OrderedMenu orderedMenu = new OrderedMenu(validation.validateOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"));
        // when
        int weekendDiscountAmount = eventCalender.selectWeekdayOrWeekend(day, orderedMenu);
        // then
        assertThat(weekendDiscountAmount).isEqualTo(4046);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void checkSpecialDiscountAmount(int day) {
        // when
        int specialDiscountAmount = eventCalender.getSpecialDiscountAmount(day);
        // then
        assertThat(specialDiscountAmount).isEqualTo(1000);
    }
}
