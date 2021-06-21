/*

to find the length of longest subsequence for the given sequence in which elements are

- in sorted order (highest to lowest)
- not necessarily contiguous or unique

*/ 

import java.util.*;

class Main{

	//BOTTOM UP
	private static int getLdsBottomUp(int[] nums){

		if(nums.length == 0){
			return 0;
		}

		int[] maxLds = new int[nums.length];
		Arrays.fill(maxLds, 1);

		int maxSoFar = 1;

		for(int i = 1; i < nums.length; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] < nums[j]){
					maxLds[i] = Math.max(maxLds[i], maxLds[j] + 1);
				}
			}
			maxSoFar = Math.max(maxLds[i], maxSoFar);
		}

		return maxSoFar;
	}

	//TOP DOWN
	private static int getLdsTopDown(int[] nums, int prevIndex, int curr, int[][] dp){

		if(curr == nums.length){
			return 0;
		}

		if(dp[prevIndex+1][curr] > 0){
			return dp[prevIndex+1][curr];
		}

		int incl = 0;
		if((prevIndex < 0) || (nums[curr] < nums[prevIndex])){
			incl = 1 + getLdsTopDown(nums, curr, curr+1, dp);
		}

		int excl = getLdsTopDown(nums, prevIndex, curr+1, dp);

		dp[prevIndex+1][curr] = Math.max(incl, excl);

		return dp[prevIndex+1][curr];
	}

	//RECURSION
	private static int getLds(int[] nums, int i, int prev){

		//i = initial index
		if(i == nums.length){
			return 0;
		}

		int incl = 0;
		if(nums[i] < prev){
			incl = 1 + getLds(nums, i+1, nums[i]);
		}

		int excl = getLds(nums, i+1, prev);

		return Math.max(incl, excl);
	}

	public static void main(String[] args){
		int[] nums = {20, 8, 12, 16, 10, 9, 18, 7};
		int[][] dp = new int[nums.length + 1][nums.length];

		for(int[] arr : dp){
			Arrays.fill(arr, -1);
		}

		int max = getLds(nums, 0, Integer.MAX_VALUE);
		int maxTopDown = getLdsTopDown(nums, -1, 0, dp);
		int maxBottomUp = getLdsBottomUp(nums);

		System.out.println(max);
		System.out.println(maxTopDown);
		System.out.println(maxBottomUp);
	}
}

/*

RECURSION
Time Complexity = O(2^n) 
Space Complexity = O(n)

TOP-DOWN
Time Complexity = O(n^2)
Space Complexity = O(n^2)

BOTTOM-UP
Time Complexity = O(n^2)
Space Complexity = O(n)

where n = number of elements

*/ 