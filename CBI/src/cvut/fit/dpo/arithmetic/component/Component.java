package cvut.fit.dpo.arithmetic.component;

import java.util.Iterator;
import java.util.List;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

/**
 * Aggregare from Iterator
 * Component from Composite
 * @author alenka
 *
 */
public abstract class Component {
	public abstract Integer evaluate();
	public abstract Iterator<ExpressionElement> inOrderIterator();
	public abstract PostOrderIterator postOrderIterator();
	
	// composite methods
	void addChild(Component child) {
		throw new UnsupportedOperationException();
	}
	
	List<Component> getChildren() {
		throw new UnsupportedOperationException();
	}
}
