package christmas;
import java.util.Calendar;

public class EventCalender {
    private int year = 2023;
    int month = Calendar.DECEMBER;

    public String confirmWeekdayOrWeekend(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) >= Calendar.FRIDAY) {
            return "주말 할인";
        }
        return "평일 할인";
    }
    public int getDdayDiscountAmount(int day) {
        int discountAmount = 0;
        if (day >= 1 && day < 26) {
            discountAmount = calculateDdayDiscountAmount(day);
        }
        return discountAmount;
    }

    private int calculateDdayDiscountAmount(int day) {
        int discountAmount = 900;
        for (int i = 0; i < day; i++) {
            discountAmount += 100;
        }
        return discountAmount;
    }

    public int selectWeekdayOrWeekend(int day, OrderedMenu orderedMenu) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) >= Calendar.FRIDAY) {
            return getWeekendDiscountAmount(orderedMenu);
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) <= Calendar.THURSDAY) {
            return getWeekdayDiscountAmount(orderedMenu);
        }
        return 0;
    }

    private int getWeekdayDiscountAmount(OrderedMenu orderedMenu) {
        int weekdayDiscountAmount = 0;
        for (String menuName : orderedMenu.getOrderedMenu().keySet()) {
            // 문자열을 비교할 때 equals와 == 차이점 공부
            if (menuName.equals("아이스크림") || menuName.equals("초코케이크")) {
                Integer menuQuantity = orderedMenu.getOrderedMenu().get(menuName);
                weekdayDiscountAmount += 2023 * menuQuantity;
            }
        }
        return weekdayDiscountAmount;
    }

    private int getWeekendDiscountAmount(OrderedMenu orderedMenu) {
        int weekendDiscountAmount = 0;
        for (String menuName : orderedMenu.getOrderedMenu().keySet()) {
            // 비교할 조건이 너무 많다. -> 간단하게 표현할 수 있는 방법을 찾아보자.
            if (menuName.equals("티본스테이크") || menuName.equals("바비큐립") || menuName.equals("해산물파스타") || menuName.equals("크리스마스파스타")) {
                Integer menuQuantity = orderedMenu.getOrderedMenu().get(menuName);
                weekendDiscountAmount += 2023 * menuQuantity;
            }
        }
        return weekendDiscountAmount;
    }

    public int getSpecialDiscountAmount(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || day == 25) {
            return 1000;
        }
        return 0;
    }
}
