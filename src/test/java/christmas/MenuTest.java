package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("메뉴의 이름과 가격이 정확히 매칭됐는지 확인한다.")
    @Test
    void menuItemPriceTest() {
        // when
        int menuPrice = Menu.getPriceByName("양송이스프");
        // then
        assertThat(menuPrice).isEqualTo(6000);
    }
}
