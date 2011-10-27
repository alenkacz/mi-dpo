package cvut.fit.dpo.arithmetic.component;

import java.util.Iterator;
import java.util.List;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

public abstract class Component {
	public abstract Integer evaluate();
	public abstract Iterator<ExpressionElement> inOrderIterator();
	public abstract PostOrderIterator postOrderIterator();
	
	// composite methods
	void addChild(Component child) {
		// do intentionally nothing
	}
	
	List<Component> getChildren() {
		return null;
	}
}
