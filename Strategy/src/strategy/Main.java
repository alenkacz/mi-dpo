package strategy;

import strategy.tree.BFS;
import strategy.tree.DFS;
import strategy.tree.TreeTraversal;
import strategy.tree.ITraversalAlgorithm;

public class Main {


	public static void main(String[] args){
		String algorithm = "";
		if( args.length != 1 ) {
			printUsage();
		} else {
			algorithm = args[0];
		}
		
		TreeGenerator generator = new TreeGenerator();
		Node root = generator.generateTree();
		
		TreeTraversal gt = new TreeTraversal(chooseAlgorithm(algorithm));
		gt.doTraversing(root);
		
		printTree(root);
	}
	
	private static void printUsage() {
		System.out.println("Need only one argument - dfs or bfs");
	}
	
	private static ITraversalAlgorithm chooseAlgorithm(String alg) {
		if(alg.equals("dfs")) {
			return new DFS();
		} else if(alg.equals("bfs")) {
			return new BFS();
		} else {
			throw new UnsupportedOperationException("Run program with dfs OR bfs parameter");
		}
	}
	
	private static void printTree(Node node) {
		System.out.println(node.getNumber());
		
		for( Node n : node.getSuccessors() ) {
			System.out.print(n.getNumber());
			System.out.print(" ");
		}
		
		System.out.print("\n");
		for( Node n : node.getSuccessors() ) {
			for( Node n2 : n.getSuccessors() ) {
				System.out.print(n2.getNumber());
				System.out.print(" ");
			}
		}
		System.out.print("\n");
	}
}
