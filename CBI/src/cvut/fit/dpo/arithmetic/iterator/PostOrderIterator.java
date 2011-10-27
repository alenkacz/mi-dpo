package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;
import java.util.Stack;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.component.Component;
import cvut.fit.dpo.arithmetic.elements.CloseBracketOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.OpenBracketOperation;

/**
 * Concrete iterator
 * @author alenka
 *
 */
public class PostOrderIterator extends BaseIterator
{	
	public PostOrderIterator(Component root) {
		super(root);
	}
	
	protected void fillStack(Object stackItem){
		if (root != stackItem && stackItem instanceof BinaryOperator) {
			BinaryOperator op = (BinaryOperator) stackItem;
			stack.push(op.postOrderIterator());
		} else {
			stack.push(new DummyIterator(stackItem));
		}
	}
	
	protected void initStack() {
		BinaryOperator operator = (BinaryOperator) root;
		
		fillStack(operator);
		fillStack(operator.getSecondOperand());
		fillStack(operator.getFirstOperand());
	}
}
