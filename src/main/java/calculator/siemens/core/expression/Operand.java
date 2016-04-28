package calculator.siemens.core.expression;

import calculator.siemens.core.expression.operation.Operation;

/**
 *
 */
public class Operand implements ArithmeticExpressionItem {

    public int getPriority() {
        return 0;
    }

    private double value;

    public Operand(double value) {
        this.value = value;
    }

    public static Operand createOperand(String serialized) {
        if (!serialized.endsWith(".")) {
            try {
                double value = Double.valueOf(serialized);
                return new Operand(value);
            } catch (NumberFormatException e) {
                //Skip exception handling
            }
        }
        return null;

    }

    public double getValue() {
        return value;
    }

    //альтернатива instanceOf в

    public boolean isOperand() {
        return true;
    }

    public boolean isOperation() {
        return false;
    }


}
