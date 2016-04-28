package calculator.siemens.core.expression;

import calculator.siemens.core.CalculatorResult;
import calculator.siemens.core.expression.operation.*;
import calculator.siemens.core.expression.operation.impl.DivOperation;
import calculator.siemens.core.expression.operation.impl.MultOperation;
import calculator.siemens.core.expression.operation.impl.SubOperation;

import java.util.*;

/**
 * name of opertion have only one symbol.
 */

public class ArithmeticExpressionImpl implements ArithmeticExpression {

    private OperationFactory operationFactory = new OperationFactoryImpl();

    private List<ArithmeticExpressionItem> items;

    public List<ArithmeticExpressionItem> getItems() {
        return items;
    }

    public String deserialize(String expression) {
        if (expression == null) {
            throw new NullPointerException("Null expression can not be deserialized");
        }
        List<ArithmeticExpressionItem> items = new ArrayList<ArithmeticExpressionItem>();

        String error = parseExpression(expression, items);
        if (error != null) {
            return error;
        }
        error = validateItemsOrder(items);
        if (error != null) {
            return error;
        }
        this.items = items;


        return null;
    }

    private String parseExpression(String expression, List<ArithmeticExpressionItem> items) {
        String tmpOperand = null;

        for (char c : expression.toCharArray()) {
            Bracket bracket = Bracket.get(c);
            Operation operation = operationFactory.getOperation(c);

            ArithmeticExpressionItem bracketOrOperation = bracket != null ? bracket : operation;

            if (bracketOrOperation != null) {
                tmpOperand = addOperandIfNotNull(tmpOperand, items);
                if (tmpOperand != null) {
                    return tmpOperand;
                }
                items.add(bracketOrOperation);
            } else {
                tmpOperand = (tmpOperand == null ? "" : tmpOperand) + c;
            }
        }
        return addOperandIfNotNull(tmpOperand, items); // add last element and return null if ok, otherwise error.
    }

    // TODO: 25.04.16  (ZA) proccess case with (*)
    // TODO: 25.04.16  (ZA) refactor the method validateItemsOrder()

    private String checkStartEndExpression(int i, List<ArithmeticExpressionItem> items, ArithmeticExpressionItem lastItems) {
        //нельзя знак в конце
        if (i == items.size() - 1 && items.get(i) instanceof Operation) {
            return "Forbidden operation in the end of expression";//нельзя знак в конце
        } else if ((items.get(i) instanceof Operation) && i == 0) {
            return "Fobidden operation on first position";//нельзя знак в начале
        } else if (lastItems != null) {
            if (equalLastCurrentItem(items.get(i), lastItems)) {
                return "Fobiden more than one operation for each other";//нельзя две операции подряд
            }
        }
        if(lastItems instanceof Bracket){
            if(items.get(i) instanceof Operation){
                return "Forbidden operation after brackets";
            }
        }
        return null;
    }

    private String checkBrackets(int i, List<ArithmeticExpressionItem> items, List<ArithmeticExpressionItem> itemList, Stack<ArithmeticExpressionItem> stackZnak) {
        if (items.get(i).equals(Bracket.OPEN_BRACKET)) {
            stackZnak.add(items.get(i));
        } else if (items.get(i).equals(Bracket.CLOSE_BRACKET)) {
            while (!stackZnak.empty()) {
                ArithmeticExpressionItem x = stackZnak.pop();
                if (!x.equals(Bracket.OPEN_BRACKET)) {
                    itemList.add(x);
                } else {
                    return null;
                }
            }
            return "Wrong positon of: )";

        }
        return null;
    }

    private String validateItemsOrder(List<ArithmeticExpressionItem> items) {

        Stack<ArithmeticExpressionItem> stackZnak = new Stack();
        List<ArithmeticExpressionItem> itemList = new ArrayList<ArithmeticExpressionItem>();
        ArithmeticExpressionItem lastItems = null;
        int countOfBrackets = 0;
        String error = "";

        for (int i = 0; i < items.size(); i++) {
            ArithmeticExpressionItem current = items.get(i);

            error = checkStartEndExpression(i, items, lastItems);
            if (error != null) {
                return error;
            }
            if (current instanceof Operand) {
                itemList.add(current);
            }
            if (current instanceof Bracket) {
                error = checkBrackets(i, items, itemList, stackZnak);
                if (error != null) {
                    return error;
                }
            }
            if (current instanceof Operation) {
                if (!stackZnak.empty()) {
                    if (equalItem(current, stackZnak.peek())) {
                        itemList.add(stackZnak.pop());
                        stackZnak.add(current);
                    } else {
                        stackZnak.add(current);
                    }
                } else {
                    stackZnak.add(current);
                }
            }

            if (i == items.size() - 1) {
                while (!stackZnak.empty()) {
                    if(stackZnak.peek() instanceof Operation || stackZnak.peek() instanceof Operand){
                        itemList.add(stackZnak.pop());
                    }else if (stackZnak.peek() instanceof Bracket){
                        return "Wrong count of brackets";
                    }
                }
            }

            lastItems = current;
        }
        items.clear();
        items.addAll(itemList);


        return null;
    }

    private String addOperandIfNotNull(String serialized, List<ArithmeticExpressionItem> items) {
        if (serialized != null) {
            Operand operand = Operand.createOperand(serialized);
            if (operand == null) {
                return "Wrong format of operand: " + serialized;
            }
            items.add(operand);
        }
        return null;
    }

    private boolean equalLastCurrentItem(ArithmeticExpressionItem x, ArithmeticExpressionItem last) {
        if (last instanceof Operation && x instanceof Operation) {
            return true;
        }
        return false;

    }

    private boolean equalItem(ArithmeticExpressionItem item1, ArithmeticExpressionItem item2) {
        if (item1.getClass().getSimpleName().equals(item2.getClass().getSimpleName())) {
            return true;
        } else if (item1.getPriority() <= item2.getPriority()) {
            return true;
        } else {
            return false;
        }

    }

    public CalculatorResult calculate() {
        if (items == null) {
            throw new IllegalStateException("Before calculation the method deserialize() must be executed without errors.");
        }

        //AEStack stack = new AEStack();
        Stack<ArithmeticExpressionItem> stack = new Stack<ArithmeticExpressionItem>();
        for (int i = 0; i < items.size(); i++) {
            ArithmeticExpressionItem current = items.get(i);
            if (current instanceof Operand) {
                stack.push(current);
            } else if (current instanceof Operation) {
                if (current instanceof BinaryOperation) {
                    Operand operand = localCalculate(current, stack.pop(), stack.pop());
                    stack.push(operand);
                }
            }
        }
        Operand operand = null;
        if (stack.peek() instanceof Operand) {
            operand = (Operand) stack.pop();
        }
        CalculatorResult calculatorResult = new CalculatorResult(operand.getValue());
        return calculatorResult;
    }

    private static class AEStack {
        Stack<ArithmeticExpressionItem> stack = new Stack<ArithmeticExpressionItem>();

        void push(ArithmeticExpressionItem item) {
            stack.push(item);
        }
        /*Operand popOperand(){
            return (Operand) stack.pop();
        }
        Operation popOperation(){
            return (Operation) stack.pop();
        }*/

        <T extends ArithmeticExpressionItem> T pop() {
            return (T) stack.pop();
        }

        <T extends ArithmeticExpressionItem> T peek() {
            return (T) stack.pop();
        }
    }

    private Operand localCalculate(ArithmeticExpressionItem operation,
                                   ArithmeticExpressionItem operand2,
                                   ArithmeticExpressionItem operand1) {

        CalculatorResult result = ((BinaryOperation) operation).calculate((Operand) operand1, (Operand) operand2);

        return new Operand(result.getValue());
    }
}
