package calculator.siemens.core.expression.operation;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.Operand;

/**
 *
 */
public  abstract  class BinaryOperation extends Operation {

    public abstract CalculatorResult calculate(Operand operand1, Operand operand2);
}
