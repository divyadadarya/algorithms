def isSafe(maze, x , y, n):

	return(x >= 0 and x < n and y >= 0 and y < n and maze[x][y] == 1)

def solveTheMaze(maze, x, y, sol, n):

	if(x == n-1 and y== n-1 and maze[x][y] == 1):
		sol[x][y] = 1
		return True

	if(isSafe(maze, x, y, n)):

		sol[x][y] = 1

		if(solveTheMaze(maze, x+1, y, sol, n)):
			return True

		if(solveTheMaze(maze, x, y+1, sol, n)):
			return True

		sol[x][y] = 1
		return False

	return False


maze = [[1, 1, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]

n = len(maze)

sol = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]

if(solveTheMaze(maze, 0, 0, sol, n)):

	for i in sol:
		for j in i:
			print(j, end = " ")
		print()

else:
	print("Path not found")
