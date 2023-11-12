package controller;

import christmas.Day;
import christmas.OrderedMenu;
import christmas.Validation;
import java.util.function.Consumer;
import java.util.function.Supplier;
import view.InputView;

public class InputValueController {
    Validation validation = new Validation();
    InputView inputView = new InputView();
    // 날짜 입력

    public Day inputDayLogic() {
        String validatedInput = inputAndValidate(inputView::readDate, validation::validateDay);
        return new Day(validatedInput);
    }

    public OrderedMenu inputOrderLogic() {
        String validatedInput = inputAndValidate(inputView::readOrder, validation::validateOrder);
        return new OrderedMenu(validatedInput);
    }


    private String inputAndValidate(Supplier<String> inputSupplier, Consumer<String> validationFunction) {
        String inputValue = "";
        while (true) {
            inputValue = inputSupplier.get();
            try {
                validationFunction.accept(inputValue);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputValue;
    }

}
