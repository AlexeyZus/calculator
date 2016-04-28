package calculator.siemens.core.expression.operation.impl;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;
import calculator.siemens.core.expression.operation.UnaryOperation;

/**
 *"Forbidden sqrt by negative expression" - error, if try get sqrt by negative expression.
 */
public class SqrtOperation extends UnaryOperation {

    public int getPriority() {
        return 2;
    }

    public boolean isOperand() {
        return false;
    }

    public boolean isOperation() {
        return true;
    }

    @Override
    public CalculatorResult calculate(Operand operand1) {
        double x1 = operand1.getValue();

        if (x1<0){
            CalculatorResult calculatorResult = new CalculatorResult("Forbidden sqrt by negative expression");
            calculatorResult.setSuccess(false);
            return calculatorResult;
        }

        CalculatorResult calculatorResult = new CalculatorResult(Math.sqrt(operand1.getValue()));
        calculatorResult.setSuccess(true);
        return calculatorResult;
    }
}
