import java.util.*;

class Main{

	static class Graph{
		int V;
		List<Integer>[] adj;

		public Graph(int V){
			this.V = V;
			adj = new ArrayList[V];

			for(int i = 0; i < adj.length; i++){
				adj[i] = new ArrayList<Integer>();
			}
		}

		public void addEdge(int u, int v){
			// u = source vertex and v = destination vertex
			adj[u].add(v); //1 -> 2, 1 -> 3, this function will add 1 -> 2, 3
		}

		public void topologicalSort(){
			int[] inDegree = new int[V];

			for(int i = 0; i < V; i++){
				ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];

				//indegree
				for(int vertex : temp){
					inDegree[vertex]++;
				}
			}

			//the vertex that we are selecting
			Queue<Integer> q = new LinkedList<Integer>();

			for(int i = 0; i < V; i++){
				if(inDegree[i] == 0){
					q.add(i);
				}
			}

			//keep track of the number selected vertices
			int c = 0;

			Vector<Integer> linearOrder = new Vector<Integer>();

			while(!q.isEmpty()){
				int x = q.poll();
				linearOrder.add(x);

				for(Integer vertex : adj[x]){
					if(--inDegree[vertex] == 0)
						q.add(vertex);
				}

				c++;
			}

			if(c != V){
				System.out.println("Graph contains negative cycle");
				return;
			}

			System.out.println("The linear order is ");
			for(int i : linearOrder){
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args){
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 4);

		g.topologicalSort();
	}
}

//Time Complexity = O(V + E)
//Space Coplexity = O(V)
//where V = number of Vertices and E = number of Edges