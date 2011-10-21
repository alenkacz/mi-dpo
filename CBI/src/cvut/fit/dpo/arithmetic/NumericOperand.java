package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.component.IComponent;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;
import cvut.fit.dpo.arithmetic.elements.Number;

/**
 * Represents number in the arithmetic expression
 * 
 * @author Jan Kurš
 */
public class NumericOperand implements IComponent {
	private Integer value;
	private ExpressionElement element;
	
	public NumericOperand(Integer value)
	{
		element = new Number(value);
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
		return new InOrderIterator(element);
	}

	public PostOrderIterator postOrderIterator()
	{
		return null;
	}
	
}
