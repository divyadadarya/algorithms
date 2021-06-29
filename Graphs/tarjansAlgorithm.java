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

	private void dfs(int curr){
		dfsNum[curr] = dfsLow[curr] = num++;
		stack.push(curr);
		visited[curr] = true;

		Iterator<Integer> i = graph[curr].iterator();
		//iterating through all its child vertices

		while(i.hasNext()){
			int to = i.next();
			if(dfsNum[to] == -1){
				dfs(to);
			}

			if(visited[to]){
				dfsLow[curr] = Math.min(dfsLow[curr], dfsLow[to]);
			}
		}

		if(dfsNum[curr] == dfsLow[curr]){
			//popping out the nodes above current vertex
			for(int node = stack.pop(); ; node = stack.pop()){
				//printing popped node
				System.out.print(node + " ");
				if(node == curr)
					break;
			}

			System.out.println();
		}
	}

	public void solve(){
		dfsNum = new int[n];
		dfsLow = new int[n];
		visited = new boolean[n];
		stack = new Stack<>();

		Array.fill(dfsNum, -1);

		for(int i = 0; i < n; i++){
			if(dfsNum[i] == -1){
				dfs(i);
			}
		}
	}

	public static void main(String[] args){
		int n = 7;
		LinkedList<Integer>[] graph = createGraph(n);

		addEdge(graph, 0, 1);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 4);
		addEdge(graph, 1, 6);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 2);
		addEdge(graph, 4, 5);
		addEdge(graph, 5, 4);
		addEdge(graph, 6, 4);
		addEdge(graph, 6, 0);

		Main sccSolver = new Main(graph);
		System.out.println("Strongly Connected Components are : ");
		sccSolver.solve();
	}
}