package strategy.tree;

import java.util.Set;

public class Tree {
	private Node root;
	private int height;
	private int siblings;
	
	public Tree() {}
	
	public Tree( int height, int siblings ) {
		this.height = height;
		this.siblings = siblings;
		
		root = new Node(0);
		generate();
	}
	
	public Node getRoot() {
		return root;
	}
	
	private void generate() {
		generateSiblings(height-1, root, 1);
	}
	
	private void generateSiblings(int height, Node node, int counter) {
		if( height == 0 ) return;
		
		for( int i = 0; i < siblings; i++ ) {
			Node n = new Node(counter);
			node.addSuccessor(n);
			generateSiblings(height-1, n, counter+getCounterIncrement(height, counter));
			counter++;
		}
	}
	
	private int getCounterIncrement(int height, int counter) {
		int heightDiff = this.height-height;
		return ((heightDiff*siblings)+(counter-(heightDiff-1)*2-1));
	}
}
