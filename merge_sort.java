class Main{

	private static void merge(int[] arr, int l, int mid, int u){

		int n1 = mid - l + 1;
		int n2 = u - mid;

		int[] right = new int[n2];
		int[] left = new int[n1];

		for(int i = 0; i < n1; i++){
			left[i] = arr[l + i];
		}

		for(int j = 0; j < n2; j++){
			right[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0, k = l;

		while(i < n1 && j < n2){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		while(i < n1){
			arr[k] = left[i];
			i++;
			k++;
		}

		while(j < n2){
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	private static void mergeSort(int[] arr, int l, int u){

		if(l < u){

			int mid = (l + u)/2;

			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, u);

			merge(arr, l, mid, u);
		}
	}

	public static void main(String[] args){

		int[] arr = {11, 6, 3, 9, 14, 66, 2};

		int n = arr.length;

		mergeSort(arr, 0, n-1);

		for(int i = 0; i < n; i++){
			System.out.println(arr[i] + " ");
		}
	}
}

//time complexity - O(nlog(n))
//space complexity - O(n)