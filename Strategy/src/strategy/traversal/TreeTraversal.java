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
	private ITraversalIterator storage;
	private int counter;
	
	public TreeTraversal( ITraversalIterator storage ) {
		this.storage = storage;
	}
	
	public void traverse(Tree t) {
		while( storage.hasNext() ) {
			System.out.print(storage.next().getNumber() + " ");
		}
	}
}
