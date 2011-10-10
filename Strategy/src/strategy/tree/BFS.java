package strategy.tree;

import java.util.LinkedList;
import java.util.Queue;

import strategy.Node;

public class BFS implements ITraversalAlgorithm {

	int counter;
	
	public BFS() {
		counter = 0;
	}
	
	@Override
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
	}

}
