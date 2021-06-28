def findMinVertex(distance, visited):
	minVertex = -1
	for i in range(len(distance)):
		if(visited[i] == False and (minVertex == -1 or (distance[i] < distance[minVertex]))):
			minVertex = i

	return minVertex

def dijkstra(adjacencyMatrix):
    v = len(adjacencyMatrix)
    
    visited = [False] * v
    distance = [0] * v
    
    for i in range(1, v):
        distance[i] = float('inf')
        
    for i in range(0, v-1):
        minVertex = findMinVertex(distance, visited)
        
        visited[minVertex] = True
        
        for j in range(0, v):
            if(adjacencyMatrix[minVertex][j] != 0 and visited[j] == False):
                newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j]
                
                if(newDistance < distance[j]):
                    distance[j] = newDistance
                    
    for i in range(0, v):
        print(i, end = " ")
        print(distance[i])

adjacencyMatrix = [[0, 3, 5, 6, 0, 8, 0],
	               [3, 0, 0, 4, 2, 0, 5],
	               [5, 0, 0, 0, 0, 4, 0],
	               [6, 4, 0, 0, 0, 1, 6],
	               [0, 2, 0, 0, 0, 0, 10],
	               [8, 0, 6, 1, 0, 0, 8],
	               [0, 8, 0, 6, 10, 8, 0]]

dijkstra(adjacencyMatrix)