package model;
import java.util.Calendar;
import java.util.Map;

public class EventCalender {
    private final int year = 2023;
    private final int month = Calendar.DECEMBER;

    // 날짜를 입력 받아 주말인지 평일인지 리턴
    public String checkReservedDayIsWeekdayOrWeekend(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) >= Calendar.FRIDAY) {
            return "주말 할인";
        }
        return "평일 할인";
    }
    // 디데이 할인 금액 리턴
    public int getDdayDiscountPrice(int day) {
        int discountPrice = 0;
        if (day >= 1 && day < 26) {
            discountPrice = calculateDdayDiscountPrice(day);
        }
        return discountPrice;
    }

    // 디데이 할인 금액 계산
    private int calculateDdayDiscountPrice(int day) {
        int discountAmount = 900;
        for (int i = 0; i < day; i++) {
            discountAmount += 100;
        }
        return discountAmount;
    }

    // 주말 또는 평일인지 확인하고 알맞은 할인 금액 반환
    public int selectWeekdayOrWeekend(int day, Map<String, Integer> orderedMenus) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) >= Calendar.FRIDAY) {
            return getWeekendDiscountPrice(orderedMenus);
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) <= Calendar.THURSDAY) {
            return getWeekdayDiscountPrice(orderedMenus);
        }
        return 0;
    }

    private int getWeekdayDiscountPrice(Map<String, Integer> orderedMenus) {
        int weekdayDiscountAmount = 0;
        for (String menuName : orderedMenus.keySet()) {
            // 문자열을 비교할 때 equals와 == 차이점 공부
            if (menuName.equals("아이스크림") || menuName.equals("초코케이크")) {
                Integer menuQuantity = orderedMenus.get(menuName);
                weekdayDiscountAmount += 2023 * menuQuantity;
            }
        }
        return weekdayDiscountAmount;
    }

    private int getWeekendDiscountPrice(Map<String, Integer> orderedMenus) {
        int weekendDiscountAmount = 0;
        for (String menuName : orderedMenus.keySet()) {
            // 비교할 조건이 너무 많다. -> 간단하게 표현할 수 있는 방법을 찾아보자.
            if (menuName.equals("티본스테이크") || menuName.equals("바비큐립") || menuName.equals("해산물파스타") || menuName.equals("크리스마스파스타")) {
                Integer menuQuantity = orderedMenus.get(menuName);
                weekendDiscountAmount += 2023 * menuQuantity;
            }
        }
        return weekendDiscountAmount;
    }

    // 스페셜 할인 금액 반환
    public int getSpecialDiscountAmount(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || day == 25) {
            return 1000;
        }
        return 0;
    }
}
