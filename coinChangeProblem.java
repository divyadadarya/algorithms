class Main{

	private static int minCoins(int[] coins, int len, int total){
		int result;

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

		System.out.println(minNumber);
	}
}