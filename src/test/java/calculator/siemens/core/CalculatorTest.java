package calculator.siemens.core;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test null input expression
 *
 */


public class CalculatorTest {
    private Calculator calculator = new CalculatorImpl();
//1
    @Test(expected = NullPointerException.class)
    public void calculate_null(){
        calculator.calculate(null);
    }
//2
    @Test
    public void calculate_unexpectedChars() throws Exception {
        calculate_fail("asd","Invalid expression: asd (unexpected chars)");
    }

    private void calculate_failUnexpectedChars(String expression){

    }
//3
    @Test
    public void calculate_empty(){
        //calculate_fail("","Input expression is not defined");
    }
//4
    @Test
    public void calculate_onlyOperations(){



        calculate_fail("+","Invalid set of elements: +"); //
        calculate_fail("-","Invalid set of elements: -");
        calculate_fail("/","Invalid set of elements: /");
        calculate_fail("*","Invalid set of elements: *");

    }
//5
    @Test
    public void calculate_brackets(){
        calculate_fail("(","Invalid set of elements: (");
        calculate_fail(")","Invalid set of elements: )");
        calculate_fail("()","Invalid set of elements: ()");
        calculate_fail(")(","Invalid set of elements: )(");
    }
    @Test
    public void calculate_point(){
        calculate_fail(".","Invalid set of elements: ()");
        calculate_fail(" ","Invalid set of elements: \" \" ");
        calculate_fail("  ","Invalid set of elements: \" \" ");
    }

    @Test
    public void calculate_fail(){
        calculate_invalidExpression("0.");
        calculate_invalidExpression(".0");
        calculate_invalidExpression("1.");
        calculate_invalidExpression(".1");
        calculate_invalidExpression("1..");
        calculate_invalidExpression(".1.");
        calculate_invalidExpression("..1");
        calculate_invalidExpression(".10");
        calculate_invalidExpression(".1.0");
        calculate_invalidExpression(".-1.0");
        calculate_invalidExpression("1-");
        calculate_invalidExpression("1+");
        calculate_invalidExpression("1*");
        calculate_invalidExpression("1/");
        calculate_invalidExpression("/1");
        calculate_invalidExpression("*1");
        calculate_invalidExpression("0-");
        calculate_invalidExpression("0+");
        calculate_invalidExpression("*0");
        calculate_invalidExpression("/0");
        calculate_invalidExpression("0*");
        calculate_invalidExpression("0/");
        calculate_invalidExpression("*5");
        calculate_invalidExpression("/5");
        calculate_invalidExpression("5*");
        calculate_invalidExpression("5/");
        calculate_invalidSetOfElements("+-1");
        calculate_invalidSetOfElements("-+1");
        calculate_invalidSetOfElements("-1*");
        calculate_invalidSetOfElements("-1/");
        calculate_invalidSetOfElements("+1*");
        calculate_invalidSetOfElements("+1/");
        calculate_invalidSetOfElements("1+-");
        calculate_invalidSetOfElements("+1-");
        calculate_invalidSetOfElements("-1+");
    }

    @Test
    public void calculate_okNumber(){
        calculate_okNumber("0", 0);
        calculate_okNumber("-0", 0);
        calculate_okNumber("+0", 0);
        calculate_okNumber("1", 1);
        calculate_okNumber("-1", -1);
        calculate_okNumber("+1", 1);
        calculate_okNumber("1.0", 1.0);
        calculate_okNumber("00", 0);
        calculate_okNumber("01", 1);
        calculate_okNumber("10", 10);
        calculate_okNumber("010", 10);
        calculate_okNumber("001", 1);
        calculate_okNumber("0001", 1);
        calculate_okNumber("0011", 11);
        calculate_okNumber("05", 5);
        calculate_okNumber("128", 128);
        calculate_okNumber("-46579", -46579);
        calculate_okNumber("12345", 12345);
        calculate_okNumber("012345", 12345);
        calculate_okNumber("-012345", -12345);
        calculate_okNumber("-012345", -12345.12345);
        calculate_okNumber("-012345.12345", -12345.12345);
        calculate_okNumber("-012345.012345", -12345.012345);
    }

    @Test
    public void calculate_failArithmeticExpression() throws Exception {


        calculate_invalidExpression("1/0");
        calculate_invalidExpression("0/0");

        calculate_invalidExpression("1/0+3");
        calculate_invalidExpression("1/0+3");
        calculate_invalidExpression("0/0+3");
        calculate_invalidExpression("3-1/0");
        calculate_invalidExpression("3+1/0");
        calculate_invalidExpression("(3+1)/0");
        calculate_invalidExpression(")3+1/0");
        calculate_invalidExpression("3+1)/0");
        calculate_invalidExpression("3+1/0)");
        calculate_invalidExpression("3(+1/)0");
        calculate_invalidExpression("(3+1/)0");
        calculate_invalidExpression("3+(1/)0");
        calculate_invalidExpression("3+)1/(0");

        calculate_invalidExpression("11+");
        calculate_invalidExpression("1+1+");
        calculate_invalidExpression("+11-");
        calculate_invalidExpression("11++1");
        calculate_invalidExpression("*11+1");
        calculate_invalidExpression("/11+1");
    }

    @Test
    public void calculate_okArithmeticExpression() throws Exception {


        calculate_okNumber("1+1",2);
        calculate_okNumber("1+0",1);
        calculate_okNumber("0+1",1);
        calculate_okNumber("1*0",0);
        calculate_okNumber("0*0",0);
        calculate_okNumber("0*1",0);

        calculate_okNumber("1+01",2);
        calculate_okNumber("1-1",0);
        calculate_okNumber("1*1",1);
        calculate_okNumber("1/1",1);
        calculate_okNumber("10/1",10);
        calculate_okNumber("1/01",1);

        calculate_okNumber("1+2",3);
        calculate_okNumber("1+02",3);
        calculate_okNumber("1-2",-1);
        calculate_okNumber("1-02",-1);
        calculate_okNumber("1-20",-19);
        calculate_okNumber("1*2",2);
        calculate_okNumber("1/2",0.5d);

        calculate_okNumber("2+1",3);
        calculate_okNumber("2-1",1);
        calculate_okNumber("2*1",2);
        calculate_okNumber("2/1",2);

        calculate_okNumber("2+2",4);
        calculate_okNumber("2-2",0);
        calculate_okNumber("2*2",4);
        calculate_okNumber("2/2",1);

        calculate_okNumber("4+17",21);
        calculate_okNumber("4-17",-13);
        calculate_okNumber("2*17",34);
        calculate_okNumber("2/17",0.117);

        calculate_okNumber("2-2+0",4);
        calculate_okNumber("0-2+2",4);
        calculate_okNumber("0-0+2",2);
        calculate_okNumber("0-2+0",2);
        calculate_okNumber("2-0+0",2);
        calculate_okNumber("0-0+0",0);


        calculate_okNumber("0*0+0",0);
        calculate_okNumber("0+0*0",0);
        calculate_okNumber("0+1*0",0);
        calculate_okNumber("0+1*1",1);
        calculate_okNumber("0+1/1",1);
        calculate_okNumber("1+1/1",2);
        calculate_okNumber("1+0/1",1);
        calculate_okNumber("1+0/1",1);
        calculate_okNumber("0+0/1",0);

        calculate_okNumber("(0+0)/1",0);
        calculate_okNumber("(0+1)/1",1);
        calculate_okNumber("(1+1)/1",2);
        calculate_okNumber("(2+(2/2))",3);
        calculate_okNumber("3+(3/3)",4);
        calculate_okNumber("3+(0/3)",3);
        calculate_okNumber("0*(0/3)",0);
        calculate_okNumber("(0+(3/3)",1);
        calculate_okNumber("(0*(3/3)",0);

        calculate_okNumber("(0)*(3/3)",0);
        calculate_okNumber("(1)*(3/3)",1);
        calculate_okNumber("(1)*(3/1)",3);
        calculate_okNumber("(1)*(0/1)",0);

        calculate_okNumber("(0)/(3/3)",0);
        calculate_okNumber("(1)/(3/3)",1);
        calculate_okNumber("(1)/(1/3)",3.00000);
        calculate_okNumber("(1)/(3/1)",1);
        calculate_okNumber("(1)/(1/3)",0.33333);
        calculate_okNumber("(1)*(0/1)",0);

        calculate_okNumber("(1)*(0/1)",0);
        calculate_okNumber("(1+1)*(0/1)",0);
        calculate_okNumber("(1+1)*(1/1)",2);
        calculate_okNumber("(1-1)*(1/1)",0);
        calculate_okNumber("(1-1*1/1)",0);
        calculate_okNumber("(1-2*1/1)",-1);
        calculate_okNumber("(2-2*1/1)",0);
        calculate_okNumber("(2-0*1/1)",2);
        calculate_okNumber("(2-0*0/1)",2);
        calculate_okNumber("(0-0*0/1)",2);
        calculate_okNumber("(2-2*2/1)",-2);
        calculate_okNumber("(2-2*3/1)",-4);
        calculate_okNumber("(5-2*2/1)",1);
        calculate_okNumber("(5+5*2/1)",15);
        calculate_okNumber("(5+01*2/1)",7);
        calculate_okNumber("(5+5*02/1)",15);
        calculate_okNumber("(5+5*2/01)",15);


        calculate_okNumber("(5+5)*(2/01)-(0*3)",20);
        calculate_okNumber("(5+5)*(2/01)-(1*3)",17);
        calculate_okNumber("(5+5)*(2/01)-(5*4)",0);
        calculate_okNumber("(05+005)*(2/01)-(5*004)",0);

        calculate_okNumber("1.5+1.0",2.5);
        calculate_okNumber("01.5+01.0",2.5);
        calculate_okNumber("1.5-1.0",0.5);
        calculate_okNumber("-1.5-1.0",-2.5);
        calculate_okNumber("+1.5-1.0",0.5);
        calculate_okNumber("-1.5+1.0",-0.5);
        calculate_okNumber("(1.5+1.0)",2.5);
        calculate_okNumber("(1.5+1.7)",3.2);

        calculate_okNumber("1.5+1.0+2.0",4.5);
        calculate_okNumber("(1.5)+(1.0)+(2.0)",4.5);
        calculate_okNumber("(1.5+1.0)+(2.0)",4.5);
        calculate_okNumber("(1.5+1.0)*(2.0)",5.0);
        calculate_okNumber("(1+1.0)*(2.0)",5.0);
        calculate_okNumber("(1+1.0)/(2.0)",1.0);
        calculate_okNumber("1.5+1.0+2.0",4.5);
        calculate_okNumber("1+1.0+2.0",4.0);
        calculate_okNumber("01+1.0+2.0",4.0);
        calculate_okNumber("01+01.0+2.0",4.0);
        calculate_okNumber("01+01.0+002.0",4.0);

    }

    /*
    * Написать тесты с варажениями
    * */



    @Test
    public void calculate_sqrt(){
        calculate_fail("sqrt(-5)","Forbidden negative number for sqrt, factorial ");
    }

    private void calculate_invalidExpression(String expression){
        calculate_fail(expression,"Invalid expression: " + expression);
    }

    private void calculate_invalidSetOfElements(String expression){
        calculate_fail(expression,"Invalid set of elements: " + expression);
    }

    private void calculate_okNumber(String expression, double expected){
        CalculatorResult calculatorResult = calculator.calculate(expression);
        assertNotNull("Result must not be null.",calculatorResult);
        assertFalse("Result must be an error.",calculatorResult.isSuccess());
        assertEquals(expected,calculatorResult.getValue(),0.000001);
    }


    private void calculate_fail(String expression, String error){
        CalculatorResult result = calculator.calculate(expression);
        assertNotNull("Result must not be null.",result);
        assertFalse("Result must be an error.",result.isSuccess());
        assertEquals(error,result.getError());
    }
}

/*
*
*
* */


/*
*
null
""
"a"
"+"
"."
"("
")"
" "
"1" далее проверка на число

" 1"
"1 "

"-1"
"-0"
"+0"
"+1"

".1"
"1."
"1.0"
"0.0"
"+1.1"
"-1.1"
"1.0."
"1.0.0"
"1.00"
"00"
"01"
"01.0"
"+-1"
"-+1"
"123456789"
"-123456789"
"123456789.123456789"
"-123456789.123456789"
* */
