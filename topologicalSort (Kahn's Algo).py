import numpy as np

class Graph:
    
    def __init__(self, V):
        self.V = V
        self.adj = [None] * V
        
        for i in range(0, V):
            self.adj[i] = []
            
    def addEdge(self, u, v):
        self.adj[u].append(v)
        
    def topologicalSort(self):
        V = self.V
        inDegree = [0] * V
        temp = []
        
        for i in range(V):
            temp = self.adj[i]
            
            for vertex in temp:
                inDegree[vertex] += 1
                
        from queue import Queue
        q = Queue()
        
        for i in range(V):
            if inDegree[i] == 0:
                q.put(i)
                
        c = 0
        vec = []
        linearOrder = []
        
        while q.empty() == False:
            x = q.get()
            linearOrder.append(x)
            
            for vertex in self.adj[x]:
                inDegree[vertex] -= 1
                if inDegree[vertex] == 0:
                    q.put(vertex)
                    
            c += 1
            
        if c != V:
            print("Graph contains negative cycle")
         

        print("Linear order is - ")
        for i in range(0, len(linearOrder)):
            print(linearOrder[i], " ")


g = Graph(5)

g.addEdge(0, 1)
g.addEdge(0, 3)
g.addEdge(1, 2)
g.addEdge(3, 1)
g.addEdge(3, 2)
g.addEdge(3, 4)

g.topologicalSort()