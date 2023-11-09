package christmas;

import static org.assertj.core.api.Assertions.assertThat;

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
}
