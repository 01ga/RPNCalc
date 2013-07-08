package calc.rpn;

public abstract class Operator{

	public abstract void accept(OperationVisitor visitor);

	
}
