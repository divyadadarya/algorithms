import java.util.List;

class Main{

	static final List<String> dictionary = List.of("RAY", "APPLE", "FAKE", "BOOKS");
	static final int M = 4, N = 4;

	private static boolean isValid(int row, int col, int[][] visited){
		return (row >= 0 && row < M && col >= 0 && col < N && visited[row][col] == 0);
	}

	private static void findWords(char[][] boogle, int[][] visited, int i, int j, String word){

		visited[i][j] = 1;
		word = word + boogle[i][j];

		if(dictionary.contains(word)){
			System.out.println(word);
		}

		for(int row = i-1; row <= i+1; row++){
			for(int col = j-1; col <= j+1; col++){
				if(isValid(row, col, visited)){

					findWords(boogle, visited, row, col, word);
				}
			}
		}

		visited[i][j] = 0;
	}

	public static void main(String[] args){

		char boogle[][] = {{'T', 'Y', 'R', 'S'},
	                       {'N', 'U', 'A', 'K'},
	                       {'Z', 'F', 'E', 'O'},
	                       {'A', 'C', 'B', 'O'}};

	    int visited[][] = new int[M][N];

	    String str = "";

	    for(int i = 0; i < M; i++){
	    	for(int j = 0; j < N; j++){
	    		findWords(boogle, visited, i, j, str);
	    	}
	    }
	}
}