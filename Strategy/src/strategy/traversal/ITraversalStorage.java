package strategy.traversal;

import strategy.tree.Node;

/**
 * Strategy interface
 * @author alenka
 *
 */
public interface ITraversalStorage {
	public Node next();
	public boolean hasNext();
}
