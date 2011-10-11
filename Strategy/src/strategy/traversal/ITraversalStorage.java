package strategy.traversal;

import strategy.tree.Node;

/**
 * Strategy interface
 * @author alenka
 *
 */
public interface ITraversalStorage {
	public void add(Node root);
	public Node get();
	public boolean isEmpty();
}
