package model;

import java.util.Calendar;
import java.util.Map;

public class EventCalender {
    private final int year = 2023;
    private final int month = Calendar.DECEMBER;
    private final String WEEKEND_DISCOUNT = "주말 할인";
    private final String WEEKDAY_DISCOUNT = "평일 할인";


    // 날짜를 입력 받아 주말인지 평일인지 리턴
    public String checkReservedDayIsWeekdayOrWeekend(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (isWeekend(calendar)) {
            return WEEKEND_DISCOUNT;
        }
        return WEEKDAY_DISCOUNT;
    }

    // 디데이 할인 금액 리턴
    public int getDdayDiscountPrice(int day) {
        int discountPrice = 0;
        if (isDayIncludeIntDdayEvent(day)) {
            discountPrice = calculateDdayDiscountPrice(day);
        }
        return discountPrice;
    }

    private boolean isDayIncludeIntDdayEvent(int day) {
        return day >= 1 && day < 26;
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
        if (isWeekend(calendar)) {
            return getWeekendDiscountPrice(orderedMenus);
        }
        if (isWeekday(calendar)) {
            return getWeekdayDiscountPrice(orderedMenus);
        }
        return 0;
    }

    private static boolean isWeekday(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) <= Calendar.THURSDAY;
    }

    private boolean isWeekend(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) >= Calendar.FRIDAY;
    }

    private int getWeekdayDiscountPrice(Map<String, Integer> orderedMenus) {
        int weekdayDiscountAmount = 0;
        for (String menuName : orderedMenus.keySet()) {
            if (isDessertMenu(menuName)) {
                Integer menuQuantity = orderedMenus.get(menuName);
                weekdayDiscountAmount += 2023 * menuQuantity;
            }
        }
        return weekdayDiscountAmount;
    }

    private boolean isDessertMenu(String menuName) {
        return menuName.equals(Menu.ICE_CREAM.getOrderedMenuName()) || menuName.equals(
                Menu.CHOCOLATE_CAKE.getOrderedMenuName());
    }

    private int getWeekendDiscountPrice(Map<String, Integer> orderedMenus) {
        int weekendDiscountAmount = 0;
        for (String menuName : orderedMenus.keySet()) {
            if (isMainMenu(menuName)) {
                Integer menuQuantity = orderedMenus.get(menuName);
                weekendDiscountAmount += 2023 * menuQuantity;
            }
        }
        return weekendDiscountAmount;
    }

    private boolean isMainMenu(String menuName) {
        return menuName.equals(Menu.T_BONE_STEAK.getOrderedMenuName()) || menuName.equals(
                Menu.BBQ_RIBS.getOrderedMenuName()) || menuName.equals(Menu.SEAFOOD_PASTA.getOrderedMenuName())
                || menuName.equals(Menu.CHRISTMAS_PASTA.getOrderedMenuName());
    }

    // 스페셜 할인 금액 반환
    public int getSpecialDiscountAmount(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        if (isSpecialDay(day, calendar)) {
            return 1000;
        }
        return 0;
    }

    private boolean isSpecialDay(int day, Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || day == 25;
    }
}
