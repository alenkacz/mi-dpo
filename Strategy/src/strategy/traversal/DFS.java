package strategy.traversal;

import java.util.Stack;

import strategy.tree.Node;

/**
 * Concrete strategy
 * @author alenka
 *
 */
public class DFS implements ITraversalStorage {

	Stack<Node> storage = new Stack<Node>();

	@Override
	public void add(Node node) {
		storage.push(node);
	}

	@Override
	public Node get() {
		return storage.pop();
	}

	@Override
	public boolean isEmpty() {
		return storage.isEmpty();
	}
	
	
	
	/*@Override
	public void traverse(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		root.setExplored(true);
		root.setNumber(counter++);
		
		while(!s.isEmpty())
		{
			Node n=(Node)s.peek();
			Node child = n.getUnivisitedChildNode();
			if(child!=null)
			{
				child.setExplored(true);
				child.setNumber(counter++);
				s.push(child);
			}
			else
			{
				s.pop();
			}
		}
	}*/

}
