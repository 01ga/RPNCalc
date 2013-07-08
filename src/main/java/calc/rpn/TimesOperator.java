package calc.rpn;

public class TimesOperator extends Operator{

	public void accept(OperationVisitor visitor){
		visitor.visit(this);
	}

	public String toString(){
		return "times ";
	}
}
