package calculator.siemens.core.expression.operation;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;

/**
 *
 */
public  abstract  class UnaryOperation extends Operation {
    public abstract CalculatorResult calculate(Operand operand1);

}
