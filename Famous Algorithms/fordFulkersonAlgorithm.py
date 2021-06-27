def printAugmentingPath(augmentingPaths):

	for i in range(len(augmentingPaths)):
		for j in range(len(augmentingPaths[i])):
			print(augmentingPaths[i][j], end = " ")
		print()

def getAugmentingPath(residualGraph, parentMapping, source, sink):
	from queue import Queue

	visited = []
	q = Queue()

	q.put(source)
	visited.append(source)

	gotThePath = False

	while q.empty() == False:
		u = q.get();

		for v in range(0, len(residualGraph)):
			if v not in visited and residualGraph[u][v] > 0:
				parentMapping[v] = u
				visited.append(v)
				q.put(v)

				if v == sink:
					gotThePath = True
					break

	return gotThePath

def getMaxFlow(graph, source, sink):
	rows = len(graph)
	cols = len(graph[0])

	residualGraph = [[0 for x in range(cols)] for y in range(rows)]

	for i in range(rows):
		for j in range(cols):
			residualGraph[i][j] = graph[i][j]

	parentMapping = {}

	augmentingPaths = [[]]

	maxFlow = 0

	while getAugmentingPath(residualGraph, parentMapping, source, sink):
		augPath = []
		flow = float('inf')

		v = sink

		while v != source:
			augPath.append(v)
			u = parentMapping[v]

			if flow > residualGraph[u][v]:
				flow = residualGraph[u][v]

			v  = u

		augPath.append(source)

		augPath.reverse()
		augmentingPaths.append(augPath)

		maxFlow += flow

		v = sink

		while v != source:
			u = parentMapping[v]
			residualGraph[u][v] -= flow
			residualGraph[v][u] += flow

			v = u 

	printAugmentingPath(augmentingPaths)

	return maxFlow


graph = [[0, 3, 2, 0, 0, 0],
	     [0, 0, 0, 2, 0, 0],
	     [0, 3, 0, 0, 3, 0],
	     [0, 0, 1, 0, 0, 3],
	     [0, 0, 0, 3, 0, 2],
	     [0, 0, 0, 0, 0, 0]]

maxFlow = getMaxFlow(graph, 0, len(graph) - 1)

print("The max flow possible from source to sink is " , maxFlow)