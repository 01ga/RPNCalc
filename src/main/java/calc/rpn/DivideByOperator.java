package calc.rpn;

public class DivideByOperator extends Operator{

	public void accept(OperationVisitor visitor){
		visitor.visit(this);
	}

	public String toString(){
		return "devide by ";
	}
}
