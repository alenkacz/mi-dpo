package strategy.tree;

import strategy.Node;

public class TreeTraversal {
	private ITraversalAlgorithm algorithm;
	
	public TreeTraversal( ITraversalAlgorithm algorithm ) {
		this.algorithm = algorithm;
	}
	
	public void doTraversing(Node root) {
		algorithm.traverse(root);
	}
}
