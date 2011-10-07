package strategy;

public class Main {
	public int main(String[] args) {
		int height = 5;
		int neighbors = 3;
		
		TreeGenerator generator = new TreeGenerator();
		Node root = generator.generateTree(height, neighbors);
		
		GraphTraversal gt = new GraphTraversal(new DFS());
		gt.doTraversing(root);
		
		return 1;
	}
}
