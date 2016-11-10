package Postfix;

public class Hw4PostfixTest {

	public static void main(String[] args) {
		String testExp = "1 + 2 * 3 ^ 4 / 6 ^ 2";
		InfixToPostfix converter = new InfixToPostfix();
		//instance a new converter object
		PostfixEvaluate value = new PostfixEvaluate();
		//instance a new evaluator
		String postfix = converter.converter(testExp);
		
		System.out.println("Infix: " + testExp);
		System.out.println("After convert:");
		System.out.println("Postfix: " + postfix);
		System.out.println("Value is: " +
						value.postfixEvaluate(postfix));
	}

}
