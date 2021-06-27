class Main{

	private static int partition(int[] arr, int lb, int ub){

		int pivot = arr[lb];
		int left = lb;
		int right = ub;
		int temp;

		while(left < right){

			while(arr[left] <= pivot && left < arr.length - 1){
				left++;
			}

			while(arr[right] > pivot && right > 0){
				right--;
			}

			//swap

			if(left < right){
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		//swap right with lb/pivot

		temp = arr[lb];
		arr[lb] = arr[right];
		arr[right] = temp;

		return right;
	}

	private static void quickSort(int[] arr, int lb, int ub){
		int index;

		if(lb < ub){

			index = partition(arr, lb, ub);

			quickSort(arr, lb, index-1);
			quickSort(arr, index+1, ub);
		}
	}

	public static void main(String[] args){
		int arr[] = {10, 1, 67, 20, 56, 34, 43, 90, 54, 8, 0};

		int n = arr.length;

		quickSort(arr, 0, n-1);

		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
	}
}

//time complexity = O(N^2)
//space complexity = O(N)