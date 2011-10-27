package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;
import java.util.Stack;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.component.Component;
import cvut.fit.dpo.arithmetic.elements.CloseBracketOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.OpenBracketOperation;

public abstract class BaseIterator implements Iterator<ExpressionElement> {
	Stack<Iterator<ExpressionElement>> stack;
	Component root = null;
	
	public BaseIterator(Component root) {
		this.root = root;
		initialize();
	}
	
	private void initialize(){
		stack = new Stack<Iterator<ExpressionElement>>();
		if( root instanceof BinaryOperator ) {
			initStack();
		} else {
			fillStack(root);
		}
	}
	
	@Override
	public boolean hasNext()
	{
		if (stack.empty()){
			return false;
		}
		
		if (stack.peek().hasNext()){
			return true;
		}

		stack.pop();
		
		return hasNext();
	}

	@Override
	public ExpressionElement next()
	{
		if (stack == null || stack.peek() == null){
			return null;
		}
		
		ExpressionElement result = stack.peek().next();
		
		if(!stack.peek().hasNext()) {
			stack.pop();
		}
		
		return result;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
	
	protected abstract void fillStack(Object o);
	protected abstract void initStack();
}
