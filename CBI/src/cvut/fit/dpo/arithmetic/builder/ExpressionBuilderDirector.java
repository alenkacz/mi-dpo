package cvut.fit.dpo.arithmetic.builder;

import java.util.Stack;

import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.component.Component;

/**
 * Director
 * @author alenka
 *
 */
public class ExpressionBuilderDirector {
	IExpressionBuilder builder;
	
	public ExpressionBuilderDirector(IExpressionBuilder builder) {
		this.builder = builder;
	}
	
	public void constructExpression1() {
		Component c1 = builder.buildAddOperator(1,2);
		builder.buildSubstractOperator(3,c1);
	}
	
	public void constructExpression2() {
		Component c1 = builder.buildSubstractOperator(3,1);
		builder.buildAddOperator(c1,2);
	}
	
	public void constructFromRPN(String input) {
		if( input == null || input.length() == 0 ) {
			throw new IllegalArgumentException("No input given");
		}
		
		String[] parts = input.split(" ");
		Stack<Component> tree = new Stack<Component>();
		
		if(parts.length == 1) {
			builder.buildSingleOperand(Integer.parseInt(parts[0]));
		}
		
		for(String part : parts) {
			if( part.matches("[1234567890]+")) {
				tree.push(new NumericOperand(Integer.parseInt(part)));
			} else {
				Component n2 = tree.pop();
				Component n1 = tree.pop();
				Component operator;
				
				if( part.equals("+") ) {
					operator = builder.buildAddOperator(n1,n2);
				} else if( part.equals("-") ) {
					operator = builder.buildSubstractOperator(n1,n2);
				} else {
					throw new IllegalArgumentException("Unknown operand");
				}
				
				tree.push(operator);
			}
		}
	}
}
