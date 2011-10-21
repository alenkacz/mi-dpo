package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.component.IComponent;
import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

/**
 * Represents the Binary operations like + - etc.
 * 
 * @author Jan Kurš
 *
 */
public abstract class BinaryOperator implements IComponent
{
	private IComponent firstOperand;
	private IComponent secondOperand;

	protected abstract Integer evaluate(Integer val1, Integer val2);
	
	public BinaryOperator(IComponent firstOperand, IComponent secondOperand)
	{
		setFirstOperand(firstOperand);
		setSecondOperand(secondOperand);
	}
	
	void setFirstOperand(IComponent o)
	{
		firstOperand = o;
	}
	void setSecondOperand(IComponent o)
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
		return null;
	}

	public PostOrderIterator postOrderIterator()
	{
		return null;
	}

	
}
