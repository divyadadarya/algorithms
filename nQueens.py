def isSafe(board, row, col, n):
    
    for i in range(0,col):
        if board[row][i] == 1:
            return False
        
    i = row
    j = col
    
    while i >= 0 and j >= 0:
        if board[i][j] == 1:
            return False
        
        i = i - 1
        j = j - 1
        
    i = row
    j = col
    
    while i < n and j >= 0:
        if board[i][j] == 1:
            return False
        
        i = i + 1
        j = j - 1
        
    return True

def saveTheQueens(board, col, n):
    if col >= n:
        return True
    
    for row in range(0, n):
        if isSafe(board, row, col, n) == True:
            board[row][col] = 1
            
            if saveTheQueens(board, col+1, n) == True:
                return True
            
            board[row][col] = 0
            
    return False

board = [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]

n = len(board)

q = saveTheQueens(board, 0, n)

if q == True:
	for i in range (0, n):
		for j in range (0, n):
			print(board[i][j], end = " ")
		print()

else:
	print("No Solution")
