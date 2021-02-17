public class nQueens{

	public static boolean isSafe(int[][] board, int row, int col, int n){
		int i, j;

		for(i = 0; i < col; i++){  //queen is placed in same row
			if(board[row][i] == 1)
				return false;
		}

		for(i = row, j = col; i >= 0 && j >= 0; i--, j--){ //queen is placed diagonally upwards
			if(board[i][j] == 1)
				return false;
		}

		for(i = row, j = col; i < n && j >= 0; i++, j--){ //queen is placed diagonally downwards
			if(board[i][j] == 1)
				return false;
		}

		return true;
	}

	public static boolean saveTheQueens(int[][] board, int col, int n){

		if(col >= n)
			return true;

		for(int row = 0; row < n; row++){

			if(isSafe(board, row, col, n)){
				board[row][col] = 1;

				if(saveTheQueens(board, col+1, n)){
					return true;
				}

				board[row][col] = 0; //backtrack
			}

		}
		return false;
	}

	public static void main(String[] args){

		int i,j;

		int[][] board = {{0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0},
	                     {0, 0, 0, 0, 0}};

	    int n = board.length;

	    if(saveTheQueens(board, 0, n)){
	    	for(i = 0; i < n; i++){
	    		for(j = 0; j < n; j++){
	    			System.out.print(" " + board[i][j] + " ");
	    		}

	    		System.out.println();
	    	}
	    } //column by column

	    else{
	    	System.out.println("No Solution");
	    }
	}
}

//time complexity - O(n!)
//space complexity - O(n)