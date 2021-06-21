// To calculate the minimum number of operations it takes to transform one string to another string

/* 

OPERATIONS THAT CAN BE PERFORMED 
    - Insertion
    - Deletion
    - Substitution

*/

import java.util.*;

class Main{

	//BOTTOM-UP

	/*

	IF str1[i-1] == str2[j-1]:
	    arr[i][j] = arr[i-1][j-1]

	ELSE:
	    arr[i][j] = 1 + min(arr[i][j-1], arr[i-1][j], arr[i-1][j-1])

	*/ 

	private static int getLDistanceBottomUp(String str1, String str2, int m, int n){
		int[][] lDist = new int[m+1][n+1];

		for(int i = 0; i < m; i++){
			lDist[0][i] = i;
		}

		for(int i = 0; i < n; i++){
			lDist[i][0] = i;
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					lDist[i][j] = lDist[i-1][j-1];
				}
				else{
					lDist[i][j] = 1 + Math.min(lDist[i][j-1], Math.min(lDist[i-1][j], lDist[i-1][j-1]));
				}
			}
		}

		return lDist[m][n];
	}

	//TOP-DOWN
	private static int getLDistanceTopDown(String str1, String str2, int m, int n, int[][] dp){
		int result;

		if(m == 0 || n ==0){
			result = Math.max(m, n);
			return result;
		}

		if(dp[m-1][n-1] >= 0){
			return dp[m-1][n-1];
		}

		int ch1 = 1 + getLDistanceTopDown(str1, str2, m, n-1, dp); //Insertion
		int ch2 = 1 + getLDistanceTopDown(str1, str2, m-1, n, dp); //Deletion

		//if last index characters are equal of both strings, k = 0, otherwise k = 1
		int k = str1.charAt(m-1) == str2.charAt(n-1) ? 0 : 1;

		int ch3 = k + getLDistanceTopDown(str1, str2, m-1, n-1, dp);

		dp[m-1][n-1] = Math.min(ch1, Math.min(ch2, ch3));
		return dp[m-1][n-1];
	}

	//RECURSION
	private static int getLDistance(String str1, String str2, int m, int n){
		int result;

		if(m == 0 || n ==0){
			result = Math.max(m, n);
			return result;
		}

		int ch1 = 1 + getLDistance(str1, str2, m, n-1); //Insertion
		int ch2 = 1 + getLDistance(str1, str2, m-1, n); //Deletion

		//if last index characters are equal of both strings, k = 0, otherwise k = 1
		int k = str1.charAt(m-1) == str2.charAt(n-1) ? 0 : 1;

		int ch3 = k + getLDistance(str1, str2, m-1, n-1);

		result = Math.min(ch1, Math.min(ch2, ch3));
		return result;
	}

	public static void main(String[] args){

		String str1 = "Tuesday";
		String str2 = "Thursday";

		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m][n];

		for(int[] is : dp){
			Arrays.fill(is, -1);
		}

		int minOperationDistance = getLDistance(str1, str2, m, n);
		int minOperationDistanceTopDown = getLDistanceTopDown(str1, str2, m, n, dp);
		int minOperationDistanceBottomUp = getLDistanceBottomUp(str1, str2, m, n);

		System.out.println(minOperationDistance);
		System.out.println(minOperationDistanceTopDown);
		System.out.println(minOperationDistanceBottomUp);
	}
}