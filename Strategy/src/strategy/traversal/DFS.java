package strategy.traversal;

import java.util.List;
import java.util.Stack;

import strategy.tree.Node;
import strategy.tree.Tree;

/**
 * Concrete strategy
 * @author alenka
 *
 */
public class DFS implements ITraversalStorage {

	Stack<Node> storage = new Stack<Node>();
	boolean first = true;

	public DFS(Tree tree) {
		storage.add(tree.getRoot());
	}
	
	@Override
	public Node next() {
		if( first ) {
			List<Node> suc = storage.peek().getSuccessors();
			
			while (suc.size() != 0) {
				for(int i = (suc.size()-1); i >= 0; i--) {
					storage.add(suc.get(i));
					suc.get(i).setExplored(true);
				}
				suc = storage.peek().getSuccessors();
			}
			
			first = false;
		}

		return storage.pop();
	}

	@Override
	public boolean hasNext() {
		return !storage.isEmpty();
	}	
	
	/*@Override
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
	
	
	
	@Override
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
