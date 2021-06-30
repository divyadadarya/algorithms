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

	private void dfs(int curr, boolean[] visited){
		visited[curr] = true;

		//recur for all adjacent vertices to current vertex
		Iterator<Integer> i = graph[curr].iterator();
		while(i.hasNext()){
			int to = i.next();
			if(!visited[to]){
				dfs(to, visited);
			}
		}

		//push vertex to stack
		stack.push(curr);
	}

	private LinkedList<Integer> reverse(){
		LinkedList<Integer> rev = createGraph(n);

		for(int u = 0; u < n; u++){
			Iterator<Integer> i = graph[u].iterator();
			while(i.hasNext()){
				int v = i.next();
				addEdge(rev, v, u);
			}
		}

		return rev;
	}

	private void df2(LinkedList<Integer> revGraph, int curr, boolean[] visited){
		visited[curr] = true;
		System.out.print(curr + " ");

		//look for adjacet vertices
		Iterator<Integer> i = revGraph[curr].iterator();
		while(i.hasNext()){
			int next = i.next();
			dfs2(revGraph, next, visited);
		}
	}

	public void solve(){
		stack = new Stack<>();
		visited = new boolean[n];
		Arrays.fill(visited, false);

		//step 1 - DFS traversal and fill stack
		for(int i = 0; i < n; i++){
			if(!visited[i]){
				dfs(i, visited);
			}
		}

		//step 2 - reverse the graph
		LinkedList<Integer> revGraph = reverse();

		Arrays.fill(visited, false);

		//step 3 - second dfs while stack becomes empty
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			//look for connected vertices
			if(!visited[curr]){
				dfs2(revGraph, curr, visited);
				System.out.println();
			}
		}
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
		System.out.println("Strongly connected components are : ");
		sccSolver.solve();
	}
}