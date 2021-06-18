/*Can reach the nth stair in ways(N) -
ways(N) = ways(N-1) + ways(N-2) + ..... + ways(N-k) 
where step size = 1 to k */

class Main{

    //Top-down
	private static int numberOfWays(int n, int k, int[] arr){
		if(n == 0){
			arr[n] = 1;
			return 1;
		}

		if(n < 0){
			return 0;
		}

		if(arr[n] != -1){
			return arr[n];
		}

		arr[n] = 0;

		for(int i = 1; i <= k; i++){
			arr[n] = arr[n] + numberOfWays(n-i, k, arr);
		}

		return arr[n];
	}

    //Bottom-up
	private static int waysBottomUp(int n, int k){
		int[] arr = new int[n+1];

		arr[0] = 1; //base case

		//loop to reach nth stair
		for(int i = 1; i <= n; i++){
			arr[i] = 0;

			//loop for steps
			for(int j = 1; j <=k; j++){
				if(i - j >= 0){
					arr[i] = arr[i] + arr[i - j];
				}
			}
		}

		return arr[n];
	}

	public static void main(String[] args){

		int n = 4; //top of the staircase
		int k = 3; //no. of steps can be taken at once

		int[] arr = new int[n+1]; // memoization

		for(int i = 0; i < arr.length; i++){
			arr[i] = -1;
		}

		//top down memoization
		int ways = numberOfWays(n, k, arr);

		//bottom up memoization
		int noOfWays = waysBottomUp(n, k);

		System.out.println("Number of ways = " + noOfWays);
	}
}

/*TIME COMPLEXITY
Recursion = O(k^n)
Bottom-up = O(k*n) but k < n therefore O(n)
Top-down = O(n)


SPACE COMPLEXITY
Recursion = O(n)
Bottom-up = O(n)
Top-Down = O(n)
*/ 