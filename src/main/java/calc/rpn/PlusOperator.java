package calc.rpn;

public class PlusOperator extends Operator{

	public void accept(OperationVisitor visitor){
		visitor.visit(this);
	}

	public String toString(){
		return "plus ";
	}
}
