package strategy;
import java.util.Set;


public class Node {
	private int number;
	private boolean explored;
	private Set<Node> successors;
	private Node parent;
	
	public Node() {
		explored = false;
		number = 0;
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public Set<Node> getSuccessors() {
		return successors;
	}

	public void setSuccessors(Set<Node> successors) {
		this.successors = successors;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Node getUnivisitedChildNode() {
		if( successors != null ) {
			for( Node n : successors ) {
				if( !n.isExplored() ) {
					return n;
				}
			}
		}
		
		return null;
	}
	
}
