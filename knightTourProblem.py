pathRow = [2, 1, -1, -2, -2, -1, 1, 2]
pathCol = [1, 2, 2, 1, -1, -2, -2, -1]

def isValidMove(board, newRow, newCol):

	return (newRow >= 0 and newRow < 8 and newCol >= 0 and newCol < 8 and board[newRow][newCol] == 0)

def knightTour(board, row, col, step):
    
    if step == 63:
        for i in range(0, 8):
            for j in range(0, 8):
                print(board[i][j], end = " ")
            print()
        return True
    
    for i in range(0, len(pathRow)):
        newRow = row + pathRow[i]
        newCol = col + pathCol[i]
        
        if isValidMove(board, newRow, newCol) == True:
            step+= 1
            board[newRow][newCol] = step
            
            if knightTour(board, newRow, newCol, step) == True:
                return True
            
            step-= 1
            board[newRow][newCol] = 0
            
    return False

board = [[0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0],
	     [0, 0, 0, 0, 0, 0, 0, 0]]

knightTour(board, 0, 0, 0)


