package calc.rpn;

public class EmptyStackEvaluationException extends RuntimeException{
	
	EmptyStackEvaluationException(){
		super("Inapropriate number of operands for evaluation");
	}
}
