package cvut.fit.dpo.pr2;

import java.util.Stack;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;
import cvut.fit.dpo.arithmetic.builder.ArithmeticExpressionBuilder;
import cvut.fit.dpo.arithmetic.builder.ExpressionBuilderDirector;
import cvut.fit.dpo.arithmetic.builder.IExpressionBuilder;
import cvut.fit.dpo.arithmetic.component.Component;


/**
 * Stupid class which can create some {@link ArithmeticExpression}s.
 * Builder client
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
		IExpressionBuilder builder = new ArithmeticExpressionBuilder();
		
		ExpressionBuilderDirector director = new ExpressionBuilderDirector(builder);
		director.constructExpression1();
		
		return builder.getExpression();
	}

	/**
	 * Creates (3 - 1) + 2
	 *
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression2()
	{
		IExpressionBuilder builder = new ArithmeticExpressionBuilder();
		
		ExpressionBuilderDirector director = new ExpressionBuilderDirector(builder);
		director.constructExpression2();
		
		return builder.getExpression();
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
		IExpressionBuilder builder = new ArithmeticExpressionBuilder();
		
		ExpressionBuilderDirector director = new ExpressionBuilderDirector(builder);
		director.constructFromRPN(input);
		
		return builder.getExpression();
	}
}
