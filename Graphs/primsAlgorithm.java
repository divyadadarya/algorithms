import java.util.*;

class Main{

	private static void getMST(int[][] graph, int V){
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);

		visited[0] = true;
		int edges = 0;

		while(edges < V - 1){
			int min = Integer.MAX_VALUE;
			int x = 0, y = 0;

			for(int u = 0; u < V; u++){
				
				//if the vertex is already visited
				if(visited[u] == true){

					//adjacent vertices having min distance
					for(int v = 0; v < V; v++){
						if(!visited[v] && graph[u][v] != 0){
							if(min > graph[u][v]){
								min = graph[u][v];
								x = u;
								y = v;
							}
						}
					}
				}
			}

			//select vertex
			System.out.println(x + "-" + y + " : " + graph[x][y]);
			visited[y] = true;
			edges += 1;
		}
	}

	public static void main(String[] args){

		int[][] graph = {{0, 3, 0, 0, 8},
	                     {3, 0, 4, 2, 0},
	                     {0, 4, 0, 10, 0},
	                     {0, 2, 10, 11, 0},
	                     {8, 0, 0, 11, 0}};

	    getMST(graph, graph.length);
	}
}