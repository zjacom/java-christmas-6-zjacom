package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import model.Menu;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    void menuItemPriceTest() {
        // given
        Menu menu = new Menu();
        // when
        int menuPrice = menu.findMenuPrice("양송이스프");
        // then
        assertThat(menuPrice).isEqualTo(6000);
    }
}
