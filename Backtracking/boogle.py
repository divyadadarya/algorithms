dictionary = ["RAY", "APPLE", "FAKE", "BOOKS"]
M = 4
N = 4

def isValid(row, col, visited):
	return (row >= 0 and row < M and col >= 0 and col < N and visited[row][col] == 0)

def findWords(boogle, visited, i, j, word):

	visited[i][j] = 1
	word = word + boogle[i][j]

	if word in dictionary:
		print(word)

	for row in range(i-1, i+2):
		for col in range(j-1, j+2):
			if isValid(row, col, visited) == True:
				findWords(boogle, visited, row, col, word)

	visited[i][j] = 0

boogle = [['T', 'Y', 'R', 'S'],
	      ['N', 'U', 'A', 'K'],
	      ['Z', 'F', 'E', 'O'],
	      ['A', 'C', 'B', 'O']]

visited = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]

string = ""

for i in range(0, M):
	for j in range(0, N):
		findWords(boogle, visited, i, j, str);
	    	
