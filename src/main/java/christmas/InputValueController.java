package christmas;

import java.util.function.Consumer;
import java.util.function.Supplier;
import model.Validation;
import view.InputView;

public class InputValueController {
    Validation validation = new Validation();
    InputView inputView = new InputView();
    // 날짜 입력

    public String inputDayLogic() {
        String validatedInput = inputAndValidate(inputView::readDate, validation::validateDay);
        return validatedInput;
    }

    public String inputOrderLogic() {
        String validatedInput = inputAndValidate(inputView::readOrder, validation::validateOrder);
        return validatedInput;
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
