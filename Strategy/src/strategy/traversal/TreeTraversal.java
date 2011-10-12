package strategy.traversal;

import java.util.Stack;

import strategy.tree.Node;
import strategy.tree.Tree;

/**
 * Context
 * @author alenka
 *
 */
public class TreeTraversal {
	private ITraversalStorage storage;
	private int counter;
	
	public TreeTraversal( ITraversalStorage storage ) {
		this.storage = storage;
	}
	
	public void traverse(Tree t) {
		while( storage.hasNext() ) {
			System.out.print(storage.next().getNumber() + " ");
		}
	}
}
