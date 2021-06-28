def getMST(graph, V):
	visited = [False] * V

	visited[0] = True

	edges = 0

	while edges < V - 1:
		minimum = float('inf')
		x = 0
		y = 0

		for u in range(0, V):
			if visited[u] == True:
				for v in range(0, V):
					if visited[v] == False and graph[u][v] != 0:
						if minimum > graph[u][v]:
							minimum = graph[u][v]
							x = u
							y = v

		print(x, " - ", y, " : ", graph[x][y])
		visited[y] = True
		edges += 1

graph = [[0, 3, 0, 0, 8], 
         [3, 0, 4, 2, 0],
         [0, 4, 0, 10, 0],
         [0, 2, 10, 11, 0],
         [8, 0, 0, 11, 0]]

l = len(graph)

getMST(graph, l)