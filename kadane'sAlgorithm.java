class Main{

	private static int maxSumSubArray(int[] arr){
		int localMax = arr[0];
		int max = arr[0];

		for(int i = 1; i < arr.length; i++){
			localMax = Math.max(localMax + arr[i], arr[i]);

			max = Math.max(max, localMax);
		}

		return max;
	}

	public static void main(String[] args){

		int[] arr = {-2, -1, 3, -2, 4, 3, -3, 5};

		int maxSum = maxSumSubArray(arr);

		System.out.println(maxSum);
	}
}

//Time Complexity = O(N)
//Space Complexity = O(1)

//where N = number of elements in the array