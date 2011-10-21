package cvut.fit.dpo.arithmetic.component;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public interface IComponent {
	Integer evaluate();
	Iterator<ExpressionElement> inOrderIterator();
}
