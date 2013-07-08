package calc.rpn;

public interface CalculatorCommands{

	void pushOperand(double num);

	void pushPlusOperator();

	void pushMinusOperator();

	void pushTimesOperator();

	void pushDivideByOperator();

	void evaluateStack();

	double popOperand();

	double peekOperand();

	boolean isStackEmpty();
}
