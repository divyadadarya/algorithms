def bellmanFord(edges, v):
    dist = [0] * (v + 1)
        
    for i in range(0, len(dist)):
        dist[i] = float('inf')
        
    dist[v] = 0

    for i in range(0, v):
        edges.append([v, i, 0])
            
    for i in range(0, v):
        for j in edges
            u = j[0]
            d = j[1]
            w = j[2]
                
            if(dist[u] != float('inf') and dist[u] + w < dist[d]):
                dist[d] = dist[u] + w

    return dist[:-1]

def findMinVertex(distance, visited):
    minVertex = -1
    for i in range(len(distance)):
        if(visited[i] == False and (minVertex == -1 or (distance[i] < distance[minVertex]))):
            minVertex = i

    return minVertex

def dijkstra(graph, newGraph, src):
    v = len(graph)
    
    visited = [False] * v
    distance = [0] * v
    
    for i in range(0, v):
        distance[i] = float('inf')

    distance[src] = 0
        
    for i in range(0, v-1):
        minVertex = findMinVertex(distance, visited)
        
        visited[minVertex] = True
        
        for j in range(0, v):
            if(graph[minVertex][j] != 0 and visited[j] == False):
                newDistance = distance[minVertex] + newGraph[minVertex][j]
                
                if(newDistance < distance[j]):
                    distance[j] = newDistance
                    
    for i in range(0, v):
        print(i, end = " ")
        print(distance[i])

def allPairShortestPath(graph):
    for u in range(0, len(graph)):
        for v in range(0, len(graph[0])):
            if graph[u][v] != 0:
                edges.append([u, v, graph[u][v]])

    distance = bellmanFord(edges, len(graph));

    rows = len(graph)
    cols = len(graph[0])
    newGraph = []

    for i in range(rows):
        col = []
        for j in range(cols):
            col.append(0)
        newGraph.append(col)

    print("Modified Graph after performing Bellman Ford Algorithm :")

    for u in range(0, len(graph)):
        for v in range(0, len(graph[u])):
            if graph[u][v] != 0:
                newGraph[u][v] = distance[u] + graph[u][v] - distance[v]

            print(newGraph[u][v], " ", end = "")

        print()

    for src in range(0, len(graph)):
        print("Shortest distance from vertex : ", src)
        dijkstra(graph, newGraph, src)

graph = [[0, 4, 0, 0, 1],
         [0, 0, 0, 0, 0],
         [0, 7, 0, -2, 0],
         [0, 1, 0, 0, 0],
         [0, 0, 0, -5, 0]]

allPairShortestPath(graph)