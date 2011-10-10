package strategy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TreeGenerator {
	public Node generateTree() {
		Node root = new Node();
		
		for( int i = 0; i < 2; i++ ) {
			root.setSuccessors(generateRow(2));
		}
		
		for( Node n : root.getSuccessors() ) {
			n.setSuccessors(generateRow(2));
		}
		
		return root;
	}
	
	private Set<Node> generateRow(int neighbors) {
		Set<Node> res = new HashSet<Node>();
		
		for( int i = 0; i < neighbors; i++ ) {
			res.add(new Node());
		}
		
		return res;
	}
}
