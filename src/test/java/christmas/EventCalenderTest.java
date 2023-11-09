package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventCalenderTest {

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

    @Test
    void checkWeekdayDiscountAmount() {
        // given
        EventCalender eventCalender = new EventCalender();
        OrderServer orderServer = new OrderServer();
        // when
        int day = 3;
        orderServer.inputStrParseToMap("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        int weekdayDiscountAmount = eventCalender.getWeekdayDiscountAmount(day, orderServer);
        // then
        assertThat(weekdayDiscountAmount).isEqualTo(4046);
    }
}
