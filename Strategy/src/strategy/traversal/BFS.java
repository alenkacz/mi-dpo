package strategy.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import strategy.tree.Node;
import strategy.tree.Tree;

/**
 * Concrete strategy
 * @author alenka
 *
 */
public class BFS implements ITraversalIterator {

	Queue<Node> storage = new LinkedList<Node>();

	public BFS(Tree tree) {
		storage.add(tree.getRoot());
	}
	
	@Override
	public Node next() {
		Node n = storage.remove();
		
		for(Node node : n.getSuccessors()) {
			if(!node.isExplored()) {
				storage.add(node);
				node.setExplored(true);
			}
		}
		
		return n;
	}

	@Override
	public boolean hasNext() {
		return !storage.isEmpty();
	}	
}
