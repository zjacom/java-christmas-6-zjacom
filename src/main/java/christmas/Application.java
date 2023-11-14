package christmas;

import model.Service;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Service service = new Service(controller.inputDay(), controller.inputOrder());
        OutputView outputView = new OutputView();
        service.serviceLogic();

        // 입력 받은 메뉴 저장하고 출력
        outputView.printOrderedMenu(service.getOrderedMenus());
        // 총 주문 금액 계산
        outputView.printTotalOrderPrice(service.getTotalOrderPrice());
        // 증정품 출력
        outputView.printGiftMenu(service.getGiftName());
        // 할인 내역 출력
        outputView.printDiscountDetails(service.getDiscountDetails(), service.getGiftPrice(),
                service.getReservedDayIsWeekdayOrWeekend());
        // 총 혜택 금액 계산하고 출력
        outputView.printTotalBenefitInfo(service.getTotalBenefitPrice());
        // 총 결제 금액 계산하고 출력
        outputView.printPayment(service.getPayment());
        // 배지 여부 확인하고 출력
        outputView.printBadge(service.getBadge());
    }
}
