import java.util.*;
class Main{

	//BOTTOM-UP
	private static int minCoinsBottomUp(int[] coins, int len, int total){
		int[] arr = new int[total + 1];
		arr[0] = 0;

		//Initialize all the other cells
		for(int i = 1; i < arr.length; i++){
			arr[i] = Integer.MAX_VALUE - 1;
			// - 1 because we are going to add 1 in multiple cases
		}

		//denominations
		for(int i = 0; i < len; i++){
			//total/target amount
			for(int j = 1; j < arr.length; j++){
				if(coins[i] <= j){
					if(1 + arr[j - coins[i]] < arr[j]){
						arr[j] = 1 + arr[j - coins[i]];
					}
				}
			}
		}

		return arr[total];
	}

	//TOP-DOWN
	private static int minCoinsTopDown(int[] coins, int len, int total, HashMap<Integer, Integer> hashmap){
		int result = Integer.MAX_VALUE;

		if(total == 0){
			return 0;
		}

		if(hashmap.containsKey(total)){
			return hashmap.get(total);
		}

		for(int i = 0; i < len; i++){
			if(coins[i] <= total){
				int subResult = minCoinsTopDown(coins, len, total - coins[i], hashmap);

				if((subResult != Integer.MAX_VALUE) && ((subResult + 1) < result)){
					result = subResult + 1;
				}
			}
		}

		hashmap.put(total, result);
		return result;
	}

	//RECURSIVE
	private static int minCoins(int[] coins, int len, int total){
		int result = Integer.MAX_VALUE;

		if(total == 0){
			return 0;
		}

		for(int i = 0; i < len; i++){
			if(coins[i] <= total){
				int subResult = minCoins(coins, len, total - coins[i]);

				if((subResult != Integer.MAX_VALUE) && ((subResult + 1) < result)){
					result = subResult + 1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args){
		int[] coins = {1, 3, 5, 2};
		int len = coins.length;
		int total = 7;

		//Minimum number of coins needed to change for 7
		int minNumber = minCoins(coins, len, total);
		int min = minCoinsTopDown(coins, len, total, new HashMap<Integer, Integer>());
		int minCoins = minCoinsBottomUp(coins, len, total);

		System.out.println(minNumber);
		System.out.println(min);
		System.out.println(minCoins);
	}
}

/*

RECURSION
Time Complexity = O(M^A) 
Space Complexity = O(A)

TOP-DOWN
Time Complexity = O(MA)
Space Complexity = O(A)

BOTTOM-UP
Time Complexity = O(MA)
Space Complexity = O(A)

where M = length of coins array and A = Target Amount

*/ 