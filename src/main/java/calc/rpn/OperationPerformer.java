package calc.rpn;

public class OperationPerformer implements OperationVisitor{

	private double a, b;
	private Operator operator;
	private double result;

	public double performOperation(double a, double b, Operator operator){
		this.a = a;
		this.b = b;
		this.operator = operator;

		operator.accept(this);
		return result;
	}

	public void visit(PlusOperator plus){
		result = a + b;
	}

	public void visit(MinusOperator minus){
		result = b - a;
	}

	public void visit(TimesOperator times){
		result = a * b;
	}

	public void visit(DivideByOperator devide){
		result = b/a;
	}
}
