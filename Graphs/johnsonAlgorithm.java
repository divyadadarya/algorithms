import java.util.*;

class Main{

	private static int[] bellmanFord(List<List<Integer>> edges, int v){
		//add arbitrary source vertex
		int[] dist = new int[v + 1];

		for(int vertex : dist){
			dist[vertex] = Integer.MAX_VALUE;
		}

		dist[v] = 0;

		//add edges from source to all the other vertices
		for(int i = 0; i < v; i++){
			edges.add(List.of(v, i, 0));
		}

		//relax V-1 times
		for(int i = 0; i < v - 1; i++){
			for(List<Integer> li : edges){
				int u = li.get(0); //source of edge
				int v1 = li.get(1); //destination
				int w = li.get(2); //weight

				if(dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v1])){
					dist[v1] = dist[u] + w;
				}
			}
		}

		//discard arbitrary source
		return Arrays.copyOfRange(dist, 0, v); //discarding items at v+1
	}

	private static int findMinVertex(int[] distance, boolean[] visited){
		int minVertex = -1;
		for(int i = 0; i < distance.length; i++){
			if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex]))
				minVertex = i;
		}

		return minVertex;
	}

	private static void dijkstra(int[][] graph, int[][] newGraph, int src){
		int v = graph.length; 

		boolean[] visited = new boolean[v];
		int[] distance = new int[v];

		for(int i = 0; i < v; i++){
			distance[i] = Integer.MAX_VALUE;		
		}

		//source to source = 0
		distance[src] = 0;

		for(int i = 0; i < v - 1; i++){
			int minVertex = findMinVertex(distance, visited);

			visited[minVertex] = true;

			for(int j = 0; j < v; j++){
				if(graph[minVertex][j] != 0 && !visited[j]){
					int newDistance = distance[minVertex] + newGraph[minVertex][j];

					if(newDistance < distance[j])
						distance[j] = newDistance;
				}
			}
		}

		for(int i = 0; i < v; i++){
			System.out.println(i + " " + distance[i]);
		}
	}

	private static void allPairShortestPath(int[][] graph){
		List<List<Integer>> edges = new ArrayList<List<Integer>>();

		for(int u = 0; u < graph.length; u++){
			for(int v = 0; v < graph[u].length; v++){
				if(graph[u][v] != 0){
					edges.add(List.of(u, v, graph[u][v])); //source, destination, weight
				}
			}
		}

		int[] distance = bellmanFord(edges, graph.length);

		//new positive edge weights

		int[][] newGraph = new int[graph.length][graph[0].length];

		System.out.println("Modified Graph after performing Bellman Ford Algorithm :");

		for(int u = 0; u < graph.length; u++){
			for(int v = 0; v < graph[u].length; v++){
				if(graph[u][v] != 0){
					newGraph[u][v] = distance[u] + graph[u][v] - distance[v];
				}

				System.out.print(newGraph[u][v] + " ");
			}

			System.out.println();
		}

		//run dijkstra's algo for every vertex as source one by one

		for(int src = 0; src < graph.length; src++){
			System.out.println("Shortest distance from vertex : " + src);
			dijkstra(graph, newGraph, src);
		}
	}

	public static void main(String[] args){

		int[][] graph = {{0, 4, 0, 0, 1},
	                     {0, 0, 0, 0, 0},
	                     {0, 7, 0, -2, 0},
	                     {0, 1, 0, 0, 0},
	                     {0, 0, 0, -5, 0}};

	    //Johnson's algorithm
	    allPairShortestPath(graph);
	}
}