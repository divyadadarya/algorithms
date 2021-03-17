class Main{

	private static int[] pathRow = {2, 1, -1, -2, -1, 1, 2};
	private static int[] pathCol = {1, 2, 2, 1, -2, -2, -1};

	private static boolean isValidMove(int[][] board, int newRow, int newCol){

		return (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8 && board[newRow][newCol] == 0);
	}

	private static boolean knightTour(int[][] board, int row, int col, int steps){

		if(step == 63){
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board.length; j++){
					System.out.print(board[i][j] + " ");
				}

				System.out.println();
			}

			return true;
		}

		for (int i = 0; i < pathRow.length ; i++ ) {

			int newRow = row + pathRow[i];
			int newCol = col + pathCol[i];

			if(isValidMove(board, newRow, newCol)){
				step++;
				board[row][col] = step;

				if(knightTour(board, newRow, newCol, step)){
					return true;
				}

				step--;
				board[newRow][newCol] = 0;
			}
		}

		return false;
	}

	public static void main(String[] args){

		int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0, 0, 0, 0}};

	    knightTour(board, 0, 0, 0);


	}
}

//time complexity - O(8^n^2)
//space complexity - O(n^2)