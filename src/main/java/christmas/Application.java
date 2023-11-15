package christmas;

import model.service.Service;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValueValidationController inputValueValidationController = new InputValueValidationController();
        Service service = new Service(inputValueValidationController.inputDay(),
                inputValueValidationController.inputOrder());
        OutputView outputView = new OutputView();

        outputView.printOrderedMenu(service.getOrderedMenus());
        outputView.printTotalOrderPrice(service.getTotalOrderPrice());
        outputView.printGiftName(service.getGiftName());
        outputView.printDiscountDetails(service.getDiscountDetails(), service.getGiftPrice(),
                service.getReservedDayIsWeekdayOrWeekend());
        outputView.printTotalBenefitPrice(service.getTotalBenefitPrice());
        outputView.printPayment(service.getPayment());
        outputView.printBadge(service.getBadge());
    }
}
