class Graph:

	INF = 9999
	V = 4

	graph = [[0, 3, INF, 2],
	         [4, 0, 6, 7],
	         [INF, 5, 0, INF],
	         [INF, INF, 1, 0]]

	def flyodWarshall(self):
		dist = self.graph
		v = self.V

		for k in range(0, v):
			for i in range(0, v):
				for j in range(0, v):
					dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

		for i in range(0, v):
			for j in range(0, v):
				if dist[i][j] == self.INF:
					print("INF ", end = "")

				else:
					print(dist[i][j], " ", end = "")

			print()

g = Graph()

g.flyodWarshall()