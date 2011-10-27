package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.component.Component;
import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

/**
 * Represents the Binary operations like + - etc.
 * Composite
 * 
 * @author Jan Kurš
 *
 */
public abstract class BinaryOperator extends Component
{
	private Component firstOperand;
	private Component secondOperand;

	protected abstract Integer evaluate(Integer val1, Integer val2);
	
	public BinaryOperator(Component firstOperand, Component secondOperand)
	{
		setFirstOperand(firstOperand);
		setSecondOperand(secondOperand);
	}
	
	void setFirstOperand(Component o)
	{
		firstOperand = o;
	}
	void setSecondOperand(Component o)
	{
		secondOperand = o;
	}
	
	public Object getFirstOperand()
	{
		return firstOperand;
	}
	
	public Object getSecondOperand()
	{
		return secondOperand;
	}
	
	public Integer evaluate()
	{
		int val1 = firstOperand.evaluate();
		int val2 = secondOperand.evaluate();
		
		return evaluate(val1, val2);
	}
	
	public InOrderIterator inOrderIterator()
	{
		return new InOrderIterator(this);
	}

	public PostOrderIterator postOrderIterator()
	{
		return new PostOrderIterator(this);
	}

	
}
