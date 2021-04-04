import java.util.Arrays;

class Main{

	private static int getPivotValue(int[] arr, int low, int high){

		if(high-low+1 <=9){
			Arrays.sort(arr);
			return arr[arr.length/2];
		}

		int[] temp = null;

		int median[] = new int[(int) Math.ceil((double)(high-low+1)/5)];

		int medianIndex = 0;

		while(high >= low){
			temp = new int[Math.min(5, high-low+1)];

			for(int i = 0; i < temp.length && low <= high; i++){
				temp[i] = arr[low];
				low++;
			}

			Arrays.sort(temp);

			median[medianIndex] = temp[temp.length/2];
			medianIndex++;
		}

		return getPivotValue(median, 0, median.length-1);
	}

	private static int partition(int[] arr, int low, int high){

		int pivot = getPivotValue(arr, low, high);
		int temp;

		while(low < high){
			while(arr[low] <= pivot)
				low++;
			while(arr[high] > pivot)
				high--;

			if(low < high){
				temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}

		return high;
	}

	private static int findMedianUtil(int[] arr, int mid, int low, int high){

		int n = partition(arr, low, high);

		int length = n-low+1;

		if(length == mid)
			return arr[n];

		if(length > mid)
			return findMedianUtil(arr, mid, low, n-1);

		else
			return findMedianUtil(arr, mid-length, n+1, high);
	}

	private static void findMedian(int[] arr){

		int n = arr.length;

		int mid = n / 2;

		int median = findMedianUtil(arr, mid+1, 0, n-1);

		System.out.println("Median = " + median);
	}

	public static void main(String[] args){

		int[] arr = {25, 24, 33, 39, 3, 18, 19, 31, 23, 49, 45, 16, 1, 29, 40, 22, 15, 20, 24, 4, 13, 34};

		findMedian(arr);
	}
}