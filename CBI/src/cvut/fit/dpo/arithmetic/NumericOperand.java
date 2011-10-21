package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.component.IComponent;
import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

/**
 * Represents number in the arithmetic expression
 * 
 * @author Jan Kurš
 */
public class NumericOperand implements IComponent {
	private Integer value;
	
	public NumericOperand(Integer value)
	{
		setValue(value);
	}
	
	public Integer evaluate()
	{
		return value;
	}
	
	public void setValue(Integer value)
	{
		this.value = value;
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
