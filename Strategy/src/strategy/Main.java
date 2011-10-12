package strategy;

import strategy.traversal.BFS;
import strategy.traversal.DFS;
import strategy.traversal.ITraversalStorage;
import strategy.traversal.TreeTraversal;
import strategy.tree.Tree;

public class Main {

	private final static int height = 5;
	private final static int siblings = 2;

	public static void main(String[] args){
		String algorithm = "";
		if( args.length != 1 ) {
			printUsage();
		} else {
			algorithm = args[0];
		}
		
		Tree tree = new Tree(height, siblings);
		
		TreeTraversal gt = new TreeTraversal(selectAlgorithm(algorithm, tree));
		gt.traverse(tree);
	}
	
	private static void printUsage() {
		System.out.println("Need only one argument - dfs or bfs");
	}
	
	private static ITraversalStorage selectAlgorithm(String alg, Tree tree) {
		if(alg.equals("dfs")) {
			return new DFS(tree);
		} else if(alg.equals("bfs")) {
			return new BFS(tree);
		} else {
			throw new UnsupportedOperationException("Run program with dfs OR bfs parameter");
		}
	}
}
