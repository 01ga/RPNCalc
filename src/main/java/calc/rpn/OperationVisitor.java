package calc.rpn;

public interface OperationVisitor{

	void visit(PlusOperator operator);

	void visit(MinusOperator operator);

	void visit(TimesOperator operator);

	void visit(DivideByOperator operator);
}
