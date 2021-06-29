import java.util.*;

class Main{

	final static int INF = 9999, V = 4;

	private static void floydWarshall(int[][] graph){
		int[][] dist = Arrays.copyOf(graph, V);

		//setting each vertex as intermediate
		for(int k = 0; k < V; k++){

			//for each vertex as source
			for(int i = 0; i < V; i++){
				//each vertex as destination for picked source
				for(int j = 0; j < V; j++){
					//updating shortest path
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		//print
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				if(dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		int[][] graph = {{0, 3, INF, 2},
	                     {4, 0, 6, 7},
	                     {INF, 5, 0, INF},
	                     {INF, INF, 1, 0}};

	    floydWarshall(graph);
	}
}