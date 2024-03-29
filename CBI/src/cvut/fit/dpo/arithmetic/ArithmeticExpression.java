package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.component.Component;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class ArithmeticExpression
{
	private Component root;
	
	public Integer evaluate()
	{
		return root.evaluate();
	}
	
	public void setRoot(Component root)
	{
		this.root = root;
	}

	/**
	 * {@link #root} field getter.
	 * 
	 * @deprecated Do not provide access to the inner representation
	 */
	public Component getRoot()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Should be implemented.
	 * 
	 * @return
	 */
	public Iterator<ExpressionElement> getInOrderIterator()
	{
		return root.inOrderIterator();
	}

	/**
	 * Should be implemented
	 * 
	 * TODO
	 * 
	 * @return
	 */
	public Iterator<ExpressionElement> getPostOrderIterator()
	{
		return root.postOrderIterator();
	}

}
