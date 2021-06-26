def printAugmentingPath(augmentingPaths):

	for i in range(len(augmentingPaths)):
		for j in range(len(augmentingPaths[i])):
			print(augmentingPaths[i][j], end = " ")
		print()

def getAugmentingPath(residualGraph, parentMapping, source, sink):
	from queue import Queue

	visited = {}
	q = Queue()

	q.put(source)
	visited.add(source)

	gotThePath = False

	while q.empty() == False:
		u = q.get();

		for v in range(0, len(residualGraph)):
			if v not in visited and residualGraph[u][v] > 0:
				parentMapping[v] = u
				visited.add(v)
				q.put(v)

				if v == sink:
					gotThePath = True
					break

	return gotThePath


