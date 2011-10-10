package strategy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TreeGenerator {
	public Node generateTree(int number, int neighbors) {
		Node root = new Node();
		
		for( int i = 0; i < number; i++ ) {
			root.setSuccessors(generateRow(neighbors));
		}
		
		for( Node n : root.getSuccessors() ) {
			n.setSuccessors(generateRow(neighbors));
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
