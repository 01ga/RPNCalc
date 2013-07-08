package calc.rpn;

public class MinusOperator extends Operator{

	public void accept(OperationVisitor visitor){
		visitor.visit(this);
	}

	public String toString(){
		return "minus ";
	}
}
