package cvut.fit.dpo.pr2;

import java.util.Stack;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;
import cvut.fit.dpo.arithmetic.component.IComponent;


/**
 * Stupid class which can create some {@link ArithmeticExpression}s.
 * 
 * @author Jan Kurš
 *
 */
public class ArithmeticExpressionCreator
{
	/**
	 * Creates 3 - (1 + 2)
	 * 
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression1()
	{
		ArithmeticExpression e = new ArithmeticExpression();
		
		NumericOperand op1 = new NumericOperand(1);
		NumericOperand op2 = new NumericOperand(2);
		NumericOperand op3 = new NumericOperand(3);
		
		BinaryOperator o2 = new AddOperator(op1, op2);
		BinaryOperator o1 = new SubstractOperator(op3, o2);
		
		e.setRoot(o1);
		return e;
	}

	/**
	 * Creates (3 - 1) + 2
	 *
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression2()
	{
		ArithmeticExpression e = new ArithmeticExpression();
		
		NumericOperand op1 = new NumericOperand(1);
		NumericOperand op2 = new NumericOperand(2);
		NumericOperand op3 = new NumericOperand(3);
		
		BinaryOperator o1 = new SubstractOperator(op3, op1);
		BinaryOperator o2 = new AddOperator(o1, op2);
		
		e.setRoot(o2);
		return e;
	}
	
	/**
	 * Creates any expression from the RPN input. This is nice and
	 * 	universal. 
	 * 
	 * @see http://en.wikipedia.org/wiki/Reverse_Polish_notation
	 * 	
	 * @param input in Reverse Polish Notation
	 * @return {@link ArithmeticExpression} equivalent to the RPN input.
	 */
	public ArithmeticExpression createExpressionFromRPN(String input)
	{
		if( input == null || input.length() == 0 ) {
			throw new IllegalArgumentException();
		}
		String[] parts = input.split(" ");
		Stack<IComponent> tree = new Stack<IComponent>();
		IComponent root = null;
		ArithmeticExpression result = new ArithmeticExpression();
		
		for(String part : parts) {
			if( part.matches("[1234567890]+")) {
				tree.push(new NumericOperand(Integer.parseInt(part)));
			} else {
				IComponent n2 = tree.pop();
				IComponent n1 = tree.pop();
				IComponent operator;
				
				if( part.equals("+") ) {
					operator = new AddOperator(n1, n2);
				} else if( part.equals("-") ) {
					operator = new SubstractOperator(n1,n2);
				} else {
					throw new IllegalArgumentException("Unknown operand");
				}
				
				tree.push(operator);
				root = operator;
			}
		}
		
		if( root == null ) {
			root = tree.pop();
		}
		
		result.setRoot(root);
		
		return result;
		
		// Good entry point for Builder :)
		//throw new UnsupportedOperationException("Don't know how to do it :(");
	}
}
