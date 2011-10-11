package strategy.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import strategy.tree.Node;

/**
 * Concrete strategy
 * @author alenka
 *
 */
public class BFS implements ITraversalStorage {

	Queue<Node> storage = new LinkedList<Node>();

	@Override
	public void add(Node node) {
		storage.add(node);
	}

	@Override
	public Node get() {
		return storage.remove();
	}

	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}
	
	/*@Override
	public void traverse(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		root.setExplored(true);
		root.setNumber(counter++);
		
		while(!q.isEmpty())
		{
			Node n = (Node) q.remove();
			Node child = null;
			while((child=n.getUnivisitedChildNode())!=null)
			{
				child.setExplored(true);
				child.setNumber(counter++);
				q.add(child);
			}
		}
	}*/

}
