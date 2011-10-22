package cvut.fit.dpo.arithmetic.component;

import java.util.Iterator;
import java.util.List;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public abstract class Component {
	public abstract Integer evaluate();
	public abstract Iterator<ExpressionElement> inOrderIterator();
	
	// composite methods
	void addChild(Component child) {
		// do intentionally nothing
	}
	
	List<Component> getChildren() {
		return null;
	}
}
