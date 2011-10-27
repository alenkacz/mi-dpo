package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;
import cvut.fit.dpo.arithmetic.elements.AddOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.SubstractOperation;

public class DummyIterator implements Iterator<ExpressionElement> {

	Object obj;
	boolean used = false;

	public DummyIterator(Object o) {
		obj = o;
	}

	@Override
	public boolean hasNext() {
		return !used;
	}

	@Override
	public ExpressionElement next() {
		used = true;
		if (obj instanceof NumericOperand) {
			return new cvut.fit.dpo.arithmetic.elements.Number(
					((NumericOperand) obj).getValue());
		} else if (obj instanceof BinaryOperator) {
			if (obj instanceof AddOperator) {
				return new AddOperation();
			} else if (obj instanceof SubstractOperator) {
				return new SubstractOperation();
			}
		} else if(obj instanceof ExpressionElement) {
			return (ExpressionElement)obj;
		}

		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}