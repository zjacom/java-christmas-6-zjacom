package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import model.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {
    @DisplayName("고객의 총 혜택 금액에 따라 배지를 받을 수 있다.")
    @Test
    void customerCanReceiveBadge() {
        // given
        Badge badge = new Badge();
        // when
        String badgeName = badge.getBadge(5000);
        // then
        assertThat(badgeName).isEqualTo("별");
    }
}
