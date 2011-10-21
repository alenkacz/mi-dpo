package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.component.IComponent;

/**
 * Represents - operation
 * 
 * @author Jan Kurš
 */
public class SubstractOperator extends BinaryOperator
{

	public SubstractOperator(IComponent firstOperand, IComponent secondOperand)
	{
		super(firstOperand, secondOperand);
	}

	@Override
	protected Integer evaluate(Integer val1, Integer val2)
	{
		return val1 - val2;
	}

}
