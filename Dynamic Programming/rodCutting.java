//Cut rod in pieces such that maximum profit is obtained

/*

rodCut(N) = {
	max(price[i-1] + rodCut(N-i))     0 < i <= N
	0                                 N <= 0
}

*/

class Main{

	//BOTTOM-UP
	/*

	for i in 1 to N
	    max of (p[j-1] + arr[i-j]) 
	    j is 1 to N - i

    */

	private static int rodCutBottomUp(int[] price, int size){
		int[] r = new int[size + 1];
		r[0] = 0;

		int maxRevenue = Integer.MIN_VALUE;

		for(int i = 1; i < r.length; i++){
			for(int j = 1; j <= i; j++){
				int maxRev = price[j-1] + r[i-j];
				maxRevenue = Math.max(maxRevenue, maxRev);
			}
			r[i] = maxRevenue;
		}

		return r[size];
	}


	//TOP-DOWN
	private static int rodCutTopDown(int[] price, int n, int[] dp){
		if(n == 0){
			return 0;
		}

		if(dp[n-1] > 0){
			return dp[n-1];
		}

		int maxRevenue = Integer.MIN_VALUE;

		for(int i = 1; i <= n; i++){
			int maxRev = price[i-1] + rodCut(price, n - i);
			maxRevenue = Math.max(maxRevenue, maxRev);
		}

		return dp[n-1] = maxRevenue;
	}

	//RECURSION
	private static int rodCut(int[] price, int n){
		if(n == 0){
			return 0;
		}

		int maxRevenue = Integer.MIN_VALUE;

		for(int i = 1; i <= n; i++){
			int maxRev = price[i-1] + rodCut(price, n - i);
			maxRevenue = Math.max(maxRevenue, maxRev);
		}

		return maxRevenue;
	}

	public static void main(String[] args){

		//each piece size has a price
		int[] price = {1, 5, 8, 9};
		int size = price.length;
		int[] dp = new int[size];

		int maxRevenue = rodCut(price, size);
		int maxRevenueTopDown = rodCutTopDown(price, size, dp);
		int maxRevenueBottomUp = rodCutBottomUp(price, size);

		System.out.println(maxRevenue);
		System.out.println(maxRevenueTopDown);
		System.out.println(maxRevenueBottomUp);
	}
}

/*

RECURSION
Time Complexity = O(2^(n-1))
Space Complexity = O(n)

TOP-DOWN
Time Complexity = O(n^2) 
Space Complexity = O(n)

BOTTOM-UP
Time Complexity = O(n^2)
Space Complexity = O(n)

where n = length of rod

*/ 