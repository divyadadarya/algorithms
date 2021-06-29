import java.util.*;

class Main{

	private int n;
	private int num = 0;
	private boolean[] visited;
	private int[] dfsNum, dfsLow;
	private Stack<Integer> stack;
	private LinkedList<Integer>[] graph;

	public Main(LinkedList<Integer>[] graph){
		if(graph == null){
			throw new IllegalArgumentException("Graph cannot be null. ");
		}

		this.graph = graph;
		this.n = graph.length;
	}

	private static LinkedList<Integer>[] createGraph(int n){
		LinkedList<Integer>[] graph = new LinkedList[n];
		for(int i = 0; i < n; i++){
			graph[i] = new LinkedList<Integer>();
		}

		return graph;
	}

	private static void addEdge(LinkedList<Integer>[] graph, int from, int to){
		graph[from].add(to);
	}

	public static void main(String[] args){
		int n = 8;
		LinkedList<Integer>[] graph = createGraph(n);

		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 0);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 4, 5);
		addEdge(graph, 6, 4);
		addEdge(graph, 5, 6);
		addEdge(graph, 6, 7);

		Main sccSolver = new Main(graph);
	}
}