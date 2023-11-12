package christmas;

import controller.InputValueController;
import java.util.Map;
import view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 날짜 및 주문 입력
        InputValueController inputValueController = new InputValueController();
        Day day = inputValueController.inputDayLogic();
        OrderedMenu orderedMenu = inputValueController.inputOrderLogic();


        OutputView outputView = new OutputView();
        PosMachine posMachine = new PosMachine();
        Menu menu = new Menu();
        EventManager eventManager = new EventManager();

        // 입력 받은 메뉴 저장하고 출력
        Map<String, Integer> orderedMenus = orderedMenu.getOrderedMenu();
        outputView.printMenu(orderedMenus);

        // 총 주문 금액 계산
        posMachine.calculateTotalOrderPrice(orderedMenu, menu);
        int totalOrderPrice = posMachine.getTotalOrderPrice();
        outputView.printOrderAmount(posMachine.getTotalOrderPrice());

        // 할인 내역 계산
        eventManager.checkCustomerCanGetDiscount(day.getDay(), orderedMenus, totalOrderPrice);
        // [디데이, 주말/평일, 특별] 반환
        List<Integer> discountInfo = eventManager.getDiscountDetails();
        // 증정품 금액 반환
        int giftPrice = eventManager.getGiftPrice(new Menu());
        outputView.printGiftMenu(eventManager.checkCustomerCanGetGift(totalOrderPrice));
        EventCalender eventCalender = new EventCalender();
        outputView.printDiscountInfo(discountInfo, giftPrice, eventCalender.confirmWeekdayOrWeekend(day.getDay()));

        // 총 혜택 금액 계산하고 출력
        int totalBenefitAmount = posMachine.calculateTotalBenefitPrice(discountInfo, giftPrice);
        outputView.printTotalBenefitInfo(totalBenefitAmount);

        // 총 결제 금액 계산하고 출력
        int payment = posMachine.calculatePayment(discountInfo);
        outputView.printPayment(payment);

        // 배지 여부 확인하고 출력
        String badge = eventManager.getBadge(totalBenefitAmount);
        outputView.printBadge(badge);
    }
}
