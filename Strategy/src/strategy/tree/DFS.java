package strategy.tree;

import java.util.Stack;

import strategy.Node;

public class DFS implements ITraversalAlgorithm {

	private int counter;
	
	public DFS() {
		counter = 0;
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
	}

}
