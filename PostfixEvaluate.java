package Postfix;
import java.util.*;

public class PostfixEvaluate {
	public Double postfixEvaluate(String exp) {
		Stack<Double> numStack = new Stack<Double> ();
		//create an empty stack to store expression number
		Scanner tokens = new Scanner(exp);
		//get in each element in the expression 
		while (tokens.hasNext()) {
			if (tokens.hasNextInt())
				numStack.push((double) tokens.nextInt());
			//if is number, push it to stack
			else {
			//if is operator
				Double num2 = numStack.pop();
				Double num1 = numStack.pop();
				String op = tokens.next();
				
				if (op.equals("+")) {
					numStack.push(num1 + num2);	
				}//store sum value
				else if (op.equals("-")) {
					numStack.push(num1 - num2);
				}//store subtract value
				else if (op.equals("*")) {
					numStack.push(num1 * num2);
				}//store multiple value
				else if (op.equals("/")) {
					numStack.push(num1 / num2);
				}//store divide value
				else if (op.equals("^")) {
					numStack.push( Math.pow(num1,num2));
				}//store exponent value
			}
		}//end of while evaluation
		return numStack.pop();
	}
}
