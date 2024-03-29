package model;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Discount {
    private final int year = 2023;
    private final int month = Calendar.DECEMBER;

    private Calendar setUpCalendarInstance(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }

    public int getDdayDiscountPrice(int day) {
        int discountPrice = 0;
        if (isDayIncludeIntDdayEvent(day)) {
            discountPrice = calculateDdayDiscountPrice(day);
        }
        return -discountPrice;
    }

    private boolean isDayIncludeIntDdayEvent(int day) {
        return day >= 1 && day < 26;
    }

    private int calculateDdayDiscountPrice(int day) {
        int discountPrice = 900;
        for (int i = 0; i < day; i++) {
            discountPrice += 100;
        }
        return discountPrice;
    }

    // 주말 할인은 [0, 할인 금액], 평일 할인은 [1, 할인 금액]을 반환한다.
    public List<Integer> getWeekendOrWeekdayDiscountPrice(int day, Map<String, Integer> orderedMenus) {
        Calendar calendar = setUpCalendarInstance(day);
        if (isWeekend(calendar)) {
            return List.of(0, getWeekendDiscountPrice(orderedMenus));
        }
        return List.of(1, getWeekdayDiscountPrice(orderedMenus));
    }

    private boolean isWeekend(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) >= Calendar.FRIDAY;
    }

    private int getWeekendDiscountPrice(Map<String, Integer> orderedMenus) {
        int weekendDiscountPrice = 0;
        for (String menuName : orderedMenus.keySet()) {
            if (isMainMenu(menuName)) {
                Integer menuQuantity = orderedMenus.get(menuName);
                weekendDiscountPrice += 2023 * menuQuantity;
            }
        }
        return -weekendDiscountPrice;
    }

    private boolean isMainMenu(String menuName) {
        return menuName.equals(Menu.T_BONE_STEAK.getOrderedMenuName()) || menuName.equals(
                Menu.BBQ_RIBS.getOrderedMenuName()) || menuName.equals(Menu.SEAFOOD_PASTA.getOrderedMenuName())
                || menuName.equals(Menu.CHRISTMAS_PASTA.getOrderedMenuName());
    }

    private int getWeekdayDiscountPrice(Map<String, Integer> orderedMenus) {
        int weekdayDiscountPrice = 0;
        for (String menuName : orderedMenus.keySet()) {
            if (isDessertMenu(menuName)) {
                Integer menuQuantity = orderedMenus.get(menuName);
                weekdayDiscountPrice += 2023 * menuQuantity;
            }
        }
        return -weekdayDiscountPrice;
    }

    private boolean isDessertMenu(String menuName) {
        return menuName.equals(Menu.ICE_CREAM.getOrderedMenuName()) || menuName.equals(
                Menu.CHOCOLATE_CAKE.getOrderedMenuName());
    }

    public int getSpecialDiscountPrice(int day) {
        Calendar calendar = setUpCalendarInstance(day);
        if (isSpecialDay(day, calendar)) {
            return -1000;
        }
        return 0;
    }

    private boolean isSpecialDay(int day, Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || day == 25;
    }
}
