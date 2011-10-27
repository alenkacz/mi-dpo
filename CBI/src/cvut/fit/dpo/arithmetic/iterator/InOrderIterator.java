package cvut.fit.dpo.arithmetic.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class InOrderIterator extends BaseIterator
{	
	public InOrderIterator(Component root) {
		super(root);
	}
	
	protected void fillStack(Object stackItem){
		if (root != stackItem && stackItem instanceof BinaryOperator) {
			BinaryOperator op = (BinaryOperator) stackItem;
			stack.push(op.inOrderIterator());
		} else {
			stack.push(new DummyIterator(stackItem));
		}
	}
	
	protected void initStack() {
		BinaryOperator operator = (BinaryOperator) root;
		
		stack.push(new DummyIterator(new CloseBracketOperation()));
		fillStack(operator.getSecondOperand());
		fillStack(operator);
		fillStack(operator.getFirstOperand());
		stack.push(new DummyIterator(new OpenBracketOperation()));
	}
}
