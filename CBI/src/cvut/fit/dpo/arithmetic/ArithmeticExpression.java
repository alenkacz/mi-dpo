package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.component.IComponent;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class ArithmeticExpression
{
	private IComponent root;
	
	public Integer evaluate()
	{
		return root.evaluate();
	}
	
	public void setRoot(IComponent root)
	{
		this.root = root;
	}

	/**
	 * {@link #root} field getter.
	 * 
	 * @deprecated Do not provide access to the inner representation
	 */
	public IComponent getRoot()
	{
		return root;
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
		throw new UnsupportedOperationException("Not yet implemented...");
	}

}
