package calc.rpn;

import org.junit.Test;

import static org.junit.Assert.*;

import calc.rpn.ReversePolishNotationCalculator;
import calc.rpn.EmptyStackEvaluationException;
import calc.rpn.IllegalNumberOfOperandsException;

public class ReversePolishNotationCalculatorTestJ4{
	/**
	 * create an instance of the calculator
	 */
	private ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
	
	
	
	
	

	/*
	 * simple tests for the basic operations
	 */
	@Test
	public void testPlus(){
		//ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
		calculator.pushOperand(3.0);
		calculator.pushOperand(2);
		System.out.println(calculator.operandsToString());
		
		calculator.pushPlusOperator();
		System.out.println(calculator.operatorsToString());

		calculator.evaluateStack();
		
		assertEquals(5.0, calculator.popOperand(), 0);
		
	}
	@Test
	public void testMinus(){
		//ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
		calculator.pushOperand(3);
		calculator.pushOperand(2.0);
		System.out.println(calculator.operandsToString());
		calculator.pushMinusOperator();
		System.out.println(calculator.operatorsToString());
		calculator.evaluateStack();
		System.out.println(calculator.operandsToString());
		assertEquals(1.0, calculator.popOperand(), 0);
		
	}
	@Test
	public void testTimes() {
		calculator.pushOperand(3.0);
		calculator.pushOperand(2);
		calculator.pushTimesOperator();
		
		calculator.evaluateStack();
		
		assertEquals(6.0, calculator.popOperand(), 0);
		
	}
	@Test
	public void testDivision(){
		calculator.pushOperand(10);
		calculator.pushOperand(2.0);
		calculator.pushDivideByOperator();
		
		calculator.evaluateStack();
		
		assertEquals(5.0, calculator.popOperand(), 0);
		
	}
	
	/**
	 * test peek and pop operations
	 */
	@Test
	public void testPeekAndPopOperand(){
		calculator.pushOperand(4.0);
		calculator.pushOperand(7.0);
		calculator.pushPlusOperator();
		calculator.evaluateStack();
		
		assertEquals(11.0, calculator.peekOperand(), 0);
		assertFalse(calculator.isStackEmpty());
		
		calculator.pushOperand(3.0);
		calculator.pushTimesOperator();
		calculator.evaluateStack();
		
		assertEquals(33.0, calculator.peekOperand(), 0);
		assertFalse(calculator.isStackEmpty());
		assertEquals(33.0, calculator.popOperand(), 0);
		assertTrue(calculator.isStackEmpty());
	}
	
	/*
	 * test some more complex calculations
	 */
	
	/**
	 * perform the calculation shown in the assignment pdf
	 * 3 * (4 + 7) = 33
	 */
	@Test
	public void testComplexComputation(){
		calculator.pushOperand(3.0);
		calculator.pushOperand(4.0);
		calculator.pushOperand(7.0);
		calculator.pushPlusOperator();
		calculator.pushTimesOperator();
		
		calculator.evaluateStack();
		
		assertEquals(33.0, calculator.popOperand(), 0);
		
	}
	
	/**
	 * perform a sequence of calculations with intermediate
	 * evaluateStack() calls
	 * 3 * (4 + 7) = 33
	 */
	@Test
	public void testSequentialComputation(){
		
		calculator.pushOperand(4.0);
		calculator.pushOperand(7.0);
		calculator.pushPlusOperator();
		calculator.evaluateStack();
		
		calculator.pushOperand(3.0);
		calculator.pushTimesOperator();
		calculator.evaluateStack();
		
		assertEquals(33.0, calculator.popOperand(), 0);
		
	}
	
	/*
	 * test handling of some illegal evaluateStack() calls
	 */
	@Test(expected=EmptyStackEvaluationException.class)
	public void testEvaluateEmptyStackIsIllegal(){
		calculator.evaluateStack();
		//assertTrue("An EmptyStackEvaluationException should heve been thrown here.", false);
	}
	@Test(expected=IllegalNumberOfOperandsException.class)
	public void testIllegalNumberOfOperandsPlus() {
		calculator.pushOperand(7.0);
		calculator.pushPlusOperator();
		calculator.evaluateStack();
		//assertTrue("An IllegalNumberOfOperandsException should heve been thrown here.", false);
	}
	@Test(expected=IllegalNumberOfOperandsException.class)
	public void testIllegalNumberOfOperandsMinus(){
			calculator.pushOperand(7.0);
			calculator.pushMinusOperator();
			calculator.evaluateStack();
			//assertTrue("An IllegalNumberOfOperandsException should heve been thrown here.", false);
	}
	@Test(expected=IllegalNumberOfOperandsException.class)
	public void testIllegalNumberOfOperandsTimes(){
		calculator.pushOperand(7.0);
		calculator.pushTimesOperator();
		calculator.evaluateStack();
		//assertTrue("An IllegalNumberOfOperandsException should heve been thrown here.", false);
	}
	@Test(expected=IllegalNumberOfOperandsException.class)
	public void testIllegalNumberOfOperandsDivide(){
		calculator.pushOperand(7.0);
		calculator.pushDivideByOperator();
		calculator.evaluateStack();
		//assertTrue("An IllegalNumberOfOperandsException should heve been thrown here.", false);
	}
	@Test(expected=IllegalNumberOfOperandsException.class)
	public void testIllegalANumberOfOperands2(){
		calculator.pushOperand(3.0);
		calculator.pushOperand(4.0);
		calculator.pushOperand(7.0);
		calculator.pushPlusOperator();
		calculator.pushTimesOperator();
		calculator.pushTimesOperator();
		calculator.evaluateStack();
		//assertTrue("An IllegalNumberOfOperandsException should heve been thrown here.", false);
	}
	

}
