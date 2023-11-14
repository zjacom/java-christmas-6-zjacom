package model;

public class Gift {
    private final String giftName = Menu.CHAMPAGNE.getOrderedMenuName();

    public String checkCustomerCanGetGift(int totalOrderPrice) {
        if (totalOrderPrice >= 120000) {
            return giftName;
        }
        return "없음";
    }
}
