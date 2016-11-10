package Postfix;
import java.util.*;

public class InfixToPostfix {

	private boolean isOperator(char c) {
	//If c in string is an operator return True;
	//If c in string is an operand  return False;
		return c == '+' || c == '-' ||
			   c == '*' || c == '/' ||
			   c == '^' || c == '(' || 
			   c == ')';
	}	
	private boolean isSpace(char c) {
	//check if c is a space
		return c == ' ';
	}
	private boolean lowerPrecedence(char op1, char op2) {
	//check if op1 is lower precedence than op2
		switch (op1) {
			case '+':
			case '-':
				return !(op2 == '+' || op2 == '-');
				//op1 is +-, op2 is +-, return false
			case '*':
			case '/':	
				return (op2 == '^' || op2 == '(');
				//op1 is */, op2 is ^ (, return true
			case '^':
				return op2 == '(';
				//op1 is ^, op2 is (, return true
			case '(':
				return true;
				//highest precedence
			default:
				return false;
		}
	}
	public String converter(String infix) {
		Stack<String> opStack = new Stack<String>();
		//Creates an empty string stack named opStack
		char c;
		StringTokenizer input = new StringTokenizer(infix,"+-*/^() ",true);
	    /*StringTokenizer(String str, String delim, boolean returnValue)
		  creates StringTokenizer with specified string, delimeter and returnValue. 
		  If return value is true, delimiter characters are considered to be tokens. 
		  If it is false, delimiter characters serve to separate tokens.*/
		StringBuffer postfix = new StringBuffer(infix.length());
		//Create buffer store result named postfix
		while (input.hasMoreTokens()) {
			String token = input.nextToken();
			c = token.charAt(0);//this token's first char
			if ((token.length() == 1 && isOperator(c))) {
			//if token is operator
				while(!opStack.empty()&&
					!lowerPrecedence(opStack.peek().charAt(0),c))
					postfix.append(" ").append(opStack.pop());
				//if operator on stack does not lower precedence,
				//it goes front
				if (c == ')') {
					String operator = opStack.pop();
					while (operator.charAt(0) != '(') {
						postfix.append(" ").append(operator);
						operator = opStack.pop();
						//pop remaining ops in the ()
					}
				}
				else
					opStack.push(token);
				//push this operator back to stack
			}
			else if ((token.length()== 1)&& isSpace(c)) {
			//pass if token is space
			}
			else {
				postfix.append(" ").append(token);
			//if token is operand, like some ints..
			}//end of if or not operator
		}//end of while switch place of operators
		while (!opStack.empty())
			postfix.append(" ").append(opStack.pop());
		return postfix.toString();
	}//end of Converter
	
	
	
	
	
	
}