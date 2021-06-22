import java.util.*;

class Main{

	//BOTTOM UP
	private static int mcmBottomUp(int[] seq, int n){
		int[][] arr = new int[n][n];

		for(int i = 0; i < arr.length; i++){
			arr[i][i] = 0;
		}

		for(int len = 2; len < n; len++){
			for(int i = 1; i <= n-len; i++){
				int j = i + len - 1;

				if(j == n)
					continue;

				int minOps = Integer.MAX_VALUE;

				for(int k = i; k < j; k++){
					int ops = arr[i][k] + arr[k+1][j] + seq[i-1] * seq[k] * seq[j];
					minOps = Math.min(ops, minOps);
					arr[i][j] = minOps;
				}
			}
		}

		return arr[1][n-1];
	}


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
		int minOperationsBottomUp = mcmBottomUp(seq, n);

		System.out.println(minOperations);
		System.out.println(minOperationsTopDown);
		System.out.println(minOperationsBottomUp);
	}
}

/*

RECURSION
Time Complexity = O(2^N) 
Space Complexity = O(N)

TOP-DOWN
Time Complexity = O(N^3)
Space Complexity = O(N^2)

BOTTOM-UP
Time Complexity = O(N^3)
Space Complexity = O(N^2)

where N = length of sequence array

*/ 