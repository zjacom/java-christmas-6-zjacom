package christmas;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    // 필드(menu)에 메뉴를 넣는 더 좋은 방법을 찾아보자.
    private Map<String, Integer> menu = new HashMap<>();
    public Menu() {
        menu.put("양송이스프", 6000);
        menu.put("타파스", 5500);
        menu.put("시저샐러드", 8000);
        menu.put("티본스테이크", 55000);
        menu.put("바비큐립", 54000);
        menu.put("해산물파스타", 35000);
        menu.put("크리스마스파스타", 25000);
        menu.put("초코케이크", 15000);
        menu.put("아이스크림", 5000);
        menu.put("제로콜라", 3000);
        menu.put("레드와인", 60000);
        menu.put("샴페인", 25000);
    }

    // 음식 이름을 받으면 매치되는 가격 리턴
    public int findMenuPrice(String menuName) {
        return menu.get(menuName);
    }

    // 증정품 품목을 받아서 가격 정보를 리턴
    public int 증정품_가격_정보(String 증정품_이름) {
        return 0;
    }
}
