package christmas;
import java.util.Calendar;

public class EventCalender {
    private int year = 2023;
    int month = Calendar.DECEMBER;

    Calendar calendar = Calendar.getInstance();

    public EventCalender() {
        calendar.set(year, month, 1);
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

    public int getWeekdayDiscountAmount(int day, OrderServer orderServer) {
        int weekdayDiscountAmount = 0;
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) >= 1 && calendar.get(Calendar.DAY_OF_WEEK) <= 5) {
            for (String menuName : orderServer.getOrderCheck().keySet()) {
                // 문자열을 비교할 때 equals와 == 차이점 공부
                if (menuName.equals("아이스크림") || menuName.equals("초코케이크")) {
                    Integer menuQuantity = orderServer.getOrderCheck().get(menuName);
                    weekdayDiscountAmount += 2023 * menuQuantity;
                }
            }
        }
        return weekdayDiscountAmount;
    }
}
