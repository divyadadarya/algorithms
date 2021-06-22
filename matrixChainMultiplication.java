import java.util.*;

class Main{

	//TOP-DOWN
	private static int mcmTopDown(int[] seq, int i, int j, int[][] arr){
		if(i == j){
			arr[i][j] = 0;
			return arr[i][j];
		}

		if(arr[i][j] >= 0){
			return arr[i][j];
		}

		int minOps = Integer.MAX_VALUE;

		for(int k = i; k < j; k++){
			int ops = mcmTopDown(seq, i, k, arr) + mcmTopDown(seq, k+1, j, arr) + seq[i-1] * seq[k] * seq[j];
			minOps = Math.min(ops, minOps);
		}

		arr[i][j] = minOps;

		return arr[i][j];
	}


	//RECURSION
	private static int mcm(int[] seq, int i, int j){
		if(i == j){
			return 0;
		}

		int minOps = Integer.MAX_VALUE;

		for(int k = i; k < j; k++){
			int ops = mcm(seq, i, k) + mcm(seq, k+1, j) + seq[i-1] * seq[k] * seq[j];
			minOps = Math.min(ops, minOps);
		}

		return minOps;
	}

	public static void main(String[] args){

		int[] seq = {4, 3, 2, 1, 5}; //A0 = 4*3, A1 = 3*2, A2 = 2*1, A3 = 1*5 (Ai are matrices)
		int n = seq.length;

		int[][] dp = new int[n][n];
		for(int[] is : dp){
			Arrays.fill(is, -1);
		}

		int minOperations = mcm(seq, 1, n-1); //array, starting and ending indices.
		int minOperationsTopDown = mcmTopDown(seq, 1, n-1, dp);

		System.out.println(minOperations);
		System.out.println(minOperationsTopDown);
	}
}