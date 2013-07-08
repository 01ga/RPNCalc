package calc.rpn;

import java.util.*;


public class ReversePolishNotationCalculator implements CalculatorCommands{

	private Stack<Double> operandStack = new Stack<Double>();
	private Stack<? extends Operator> operatorStack = new Stack<>();
	private OperationPerformer op = new OperationPerformer();


	public void pushOperand(double operand){
		operandStack.push(operand);
	}

	public void pushPlusOperator(){
		((Vector)operatorStack).add(0, new PlusOperator());
	}

	public void pushMinusOperator(){
		((Vector)operatorStack).add(0, new MinusOperator());
	}

	public void pushTimesOperator(){
		((Vector)operatorStack).add(0, new TimesOperator());
	}

	public void pushDivideByOperator(){
		((Vector)operatorStack).add(0, new DivideByOperator());
	}

	public double popOperand(){
		return operandStack.pop();
	}

	public double peekOperand(){
		return operandStack.peek();
	}

	public boolean isStackEmpty(){
		return operandStack.empty();
	}

	public void evaluateStack(){
		validateEvaluateStack();

		while(!operatorStack.empty()){
			operandStack.push( op.performOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()) );
		}
	}

	private void validateEvaluateStack(){
		if(isStackEmpty())  throw new EmptyStackEvaluationException();

		if( !( operandStack.size() == operatorStack.size()+1 && operandStack.size() > 1) ) throw new IllegalNumberOfOperandsException();
	}

	public String operandsToString(){
		String str = new String();
		for(double operand: operandStack){
			str = str + (operand + " ");
		}
		return str;
	}

	public String operatorsToString(){
		String str = new String();
		for(Operator operand: operatorStack){
			str = str + (operand.toString() + " ");
		}
		return str;
	}


}
