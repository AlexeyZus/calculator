package calculator.siemens.core;

import java.util.List;

/**
 *
 */
public class ErrorMessage {
    public static final String INVALID_EXPRESSION = "Invalid expression: {EXPRESSION}";

    public static String resolveErrorMessage(String expression,String errorMessage){
        return errorMessage.replace("{EXPRESSION}",expression);
    }
}
