class Main{

	//BOTTOM-UP (MEMOIZATION + RECURSION)
	private static int getMaxProfitBottomUp(int[] weight, int[] profit, int n, int capacity){
		
		int[][] values = new int[n+1][capacity+1];

		for(int i = 0; i <= n; i++){

			for(int j = 0; j <= capacity; j++){

				if(i == 0 || j == 0){
					values[i][j] = 0;
				}

				else{
					int incl = 0, excl = 0;

					if(weight[i-1] <= j){
						incl = profit[i-1] + values[i-1][j - weight[i-1]];
					}

					excl = values[i-1][j];

					values[i][j] = Math.max(incl, excl);
				}
			}
		}

		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= capacity; j++){
				System.out.print(values[i][j] + " ");
			}
			System.out.println();
		}

		return values[n][capacity];
	} 

	//TOP-DOWN (MEMOIZATION + RECURSION)
	private static int getMaxProfit(int[] weight, int[] profit, int n, int capacity, int[][] values){
		if(n == 0 || capacity == 0){
			values[n][capacity] = 0;
			return 0;
		}

		if(values[n-1][capacity-1] != -1){
			return values[n-1][capacity-1];
		}

		int incl = 0, excl = 0;

		if(weight[n-1] <= capacity){
			incl = profit[n-1] + getMaxProfit(weight, profit, n-1, capacity - weight[n-1], values);
		}

		excl = getMaxProfit(weight, profit, n-1, capacity, values);

		values[n-1][capacity-1] = Math.max(incl, excl);

		return values[n-1][capacity-1];
	}

	public static void main(String[] args){

		int[] weight = {7, 4, 5};
		int[] profit = {15, 8, 8};

		int capacity = 10;

		int n = weight.length;

		//array to store all the intermediate and final values.
		//we are adding 1 for the size because we will store the values when there is no items present in the bag.
		int[][] values = new int[n+1][capacity+1];

		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= capacity; j++){
				values[i][j] = -1;
			}
		}

		int maxProfitTopDown = getMaxProfit(weight, profit, n, capacity, values);
		int maxProfitBottomUp = getMaxProfitBottomUp(weight, profit, n, capacity); 

		System.out.println(maxProfitTopDown);
		System.out.println(maxProfitBottomUp);
	}
}

/*

RECURSION
Time Complexity = O(2^n)
Space Complexity = O(n)

TOP-DOWN
Time Complexity = O(nw) 
Space Complexity = O(nw)

BOTTOM-UP
Time Complexity = O(nw)
Space Complexity = O(nw)

where n = no. of items and w = capacity of knapsack

*/ 