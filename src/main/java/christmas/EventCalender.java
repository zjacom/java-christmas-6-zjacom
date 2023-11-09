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
}
