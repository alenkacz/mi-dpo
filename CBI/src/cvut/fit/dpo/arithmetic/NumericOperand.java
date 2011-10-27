package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.component.Component;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;
import cvut.fit.dpo.arithmetic.elements.Number;

/**
 * Represents number in the arithmetic expression
 * 
 * @author Jan Kurš
 */
public class NumericOperand extends Component {
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
	
	public Integer getValue()
	{
		return value;
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
