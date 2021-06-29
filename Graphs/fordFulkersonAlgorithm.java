import java.util.*;

//Ford Fulkerson usinf BFS is also called Edmonds Karp
class Main{

	private static void printAugmentingPaths(List<List<Integer>> augmentingPaths){
		augmentingPaths.forEach(path -> {
			path.forEach(e -> System.out.print(e + " "));
			System.out.println();
		});
	}

	private static boolean getAugmentingPath(int[][] residualGraph, Map<Integer, Integer> parentMapping, int source, int sink){
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited.add(source);

		boolean gotThePath = false;

		while(!queue.isEmpty()){
			int u = queue.poll();

			for(int v = 0; v < residualGraph.length; v++){
				if(!visited.contains(v) && residualGraph[u][v] > 0){
					parentMapping.put(v, u);
					visited.add(v);
					queue.add(v);

					if(v == sink){
						gotThePath = true;
						break;
					}
				}
			}
		}

		return gotThePath;
	}

	private static int getMaxFlow(int[][] graph, int source, int sink){
		int[][] residualGraph = new int[graph.length][graph[0].length];

		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[0].length; j++){
				residualGraph[i][j] = graph[i][j];
			}
		}

		Map<Integer, Integer> parentMapping = new HashMap<Integer, Integer>();
		List<List<Integer>> augmentingPaths = new ArrayList<List<Integer>>();

		int maxFlow = 0;

		while(getAugmentingPath(residualGraph, parentMapping, source, sink)){
			List<Integer> augPath = new ArrayList<Integer>();
			int flow = Integer.MAX_VALUE;

			int v = sink;
			while(v != source){
				augPath.add(v);
				int u = parentMapping.get(v);

				if(flow > residualGraph[u][v]){
					flow = residualGraph[u][v];
				}

				v = u;
			}

			augPath.add(source);

			Collections.reverse(augPath);
			augmentingPaths.add(augPath);

			maxFlow += flow;

			v = sink;

			while(v != source){
				int u = parentMapping.get(v);
				residualGraph[u][v] -= flow;  //forward edges having residual capacity
				residualGraph[v][u] += flow;  //backward edges having shrinking capacity

				v = u;
			}
		}

		printAugmentingPaths(augmentingPaths);

		return maxFlow;
	}

	public static void main(String[] args){
		int[][] graph = {{0, 3, 2, 0, 0, 0},
	                    {0, 0, 0, 2, 0, 0},
	                    {0, 3, 0, 0, 3, 0},
	                    {0, 0, 1, 0, 0, 3},
	                    {0, 0, 0, 3, 0, 2},
	                    {0, 0, 0, 0, 0, 0}};

	    int maxFlow = getMaxFlow(graph, 0, graph.length - 1);

	    System.out.println("The max flow possible from source to sink is " + maxFlow);
	}
}