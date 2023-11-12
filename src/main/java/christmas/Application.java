package christmas;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean token = true;
        Validation validation = new Validation();
        InputView inputView = new InputView();
        // 날짜 입력
        int day = 0;
        while (token) {
            try {
                day = validation.validateDay(inputView.readDate());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String orderMenu = "";
        // 메뉴 입력
        while (token) {
            orderMenu = inputView.readOrder();
            try {
                validation.validateOrder(orderMenu);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        OrderedMenu orderedMenu = new OrderedMenu(orderMenu);
        Map<String, Integer> orderInfo = orderedMenu.getOrderedMenu();
        OutputView outputView = new OutputView();
        outputView.printMenu(orderInfo);
        PosMachine posMachine = new PosMachine();
        Menu menu = new Menu();
        posMachine.calculateTotalOrderAmount(orderedMenu, menu);
        outputView.printOrderAmount(posMachine.getTotalOrderAmount());
        EventManager eventManager = new EventManager();
        eventManager.collectDiscountInfo(day, orderedMenu, posMachine);
        List<Integer> discountInfo = eventManager.getDiscountInfo();
        int giftPrice = eventManager.getGiftInfo(posMachine, menu);
        outputView.printGiftMenu(eventManager.queryReceiveGift());
        EventCalender eventCalender = new EventCalender();
        outputView.printDiscountInfo(discountInfo, giftPrice, eventCalender.confirmWeekdayOrWeekend(day));
        int totalBenefitAmount = posMachine.calculateTotalBenefitAmount(discountInfo, giftPrice);
        outputView.printTotalBenefitInfo(totalBenefitAmount);
        int payment = posMachine.calculatePayment(discountInfo);
        outputView.printPayment(payment);
        String badge = eventManager.getBadge(totalBenefitAmount);
        outputView.printBadge(badge);
    }
}
