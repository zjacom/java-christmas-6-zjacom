package christmas;

import java.util.function.Consumer;
import java.util.function.Supplier;
import model.Validation;
import view.InputView;

public class InputValueValidationController {
    Validation validation = new Validation();
    InputView inputView = new InputView();

    public String inputDay() {
        return inputAndValidate(inputView::readDate, validation::validateDay);
    }

    public String inputOrder() {
        return inputAndValidate(inputView::readOrder, validation::validateOrder);
    }

    private String inputAndValidate(Supplier<String> inputSupplier, Consumer<String> validationFunction) {
        String inputValue;
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
