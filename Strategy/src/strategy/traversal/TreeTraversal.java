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
		Node root = t.getRoot();
		storage.add(root);
		root.setExplored(true);
		System.out.print(root.getNumber() + " ");
		
		while(!storage.isEmpty())
		{
			Node n = (Node) storage.get();
			Node child = n.getUnivisitedChildNode();
			if(child != null)
			{
				child.setExplored(true);
				System.out.print(child.getNumber() + " ");
				storage.add(child);
			}
		}
	}
}
