class Graph:
    
    class Edge:
        def __init__(self):
            s = 0
            d = 0
            w = 0
            
    edge = []
    
    def __init__(self, v, e):
        self.V = v
        self.E = e
        
        self.edge = [self.Edge()] * e
        for i in range(0, e):
            self.edge[i] = self.Edge()
            
    def bellmanFord(self, s):
        V = self.V
        e = self.E
        
        dist = [0] * V
        
        for i in range(0, len(dist)):
            dist[i] = float('inf')
            dist[s] = 0
            
        for i in range(0, V):
            for j in range(0, e):
                u = self.edge[j].s
                v = self.edge[j].d
                c = self.edge[j].w
                
                if(dist[u] != float('inf') and dist[u] + c < dist[v]):
                    dist[v] = dist[u] + c

        # negative cycle           
        for j in range(0, e):
            u = self.edge[j].s
            v = self.edge[j].d
            c = self.edge[j].w
            
            if(dist[u] != float('inf') and dist[u] + c < dist[v]):
                print("The graph contains negative cycle")

        #Print the distances of each vertex      
        print("Vertex Distance from Source")
        for i in range(V):
            print("{0}\t\t{1}".format(i, dist[i]))

g = Graph(6, 9)

#A = 0, B = 1, C = 2, D = 3, E = 4, F = 5

#AB, 01

g.edge[0].s = 0
g.edge[0].d = 1
g.edge[0].w = 8

#AF, 05

g.edge[1].s = 0
g.edge[1].d = 5
g.edge[1].w = 5

#AD, 03

g.edge[2].s = 0
g.edge[2].d = 3
g.edge[2].w = 3

#BC, 12

g.edge[3].s = 1
g.edge[3].d = 2
g.edge[3].w = 6

#CE, 24

g.edge[4].s = 2
g.edge[4].d = 4
g.edge[4].w = 4

#DE, 34

g.edge[5].s = 3
g.edge[5].d = 4
g.edge[5].w = -1

#FB, 51

g.edge[6].s = 5
g.edge[6].d = 1
g.edge[6].w = -4

#FC, 52

g.edge[7].s = 5
g.edge[7].d = 2
g.edge[7].w = -1

#FE, 54

g.edge[8].s = 5
g.edge[8].d = 4
g.edge[8].w = -3

g.bellmanFord(0) #source vertex