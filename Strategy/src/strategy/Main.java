package strategy;

import strategy.traversal.BFS;
import strategy.traversal.DFS;
import strategy.traversal.ITraversalIterator;
import strategy.traversal.TreeTraversal;
import strategy.tree.Tree;

public class Main {

	private final static int height = 4;
	private final static int siblings = 2;

	public static void main(String[] args){
		String algorithm = null;
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
		System.out.println("Need exactly one argument - dfs or bfs");
	}
	
	private static ITraversalIterator selectAlgorithm(String alg, Tree tree) {
		if(alg.equals("dfs")) {
			return new DFS(tree);
		} else if(alg.equals("bfs")) {
			return new BFS(tree);
		} else {
			System.out.println("Run program with dfs OR bfs parameter");
			System.exit(1);
			
			return null;
		}
	}
}
