package calc.rpn;

public class IllegalNumberOfOperandsException extends RuntimeException{
	
	IllegalNumberOfOperandsException(){
		super("The stack must not be empty to be evaluated");
	}
}
	
