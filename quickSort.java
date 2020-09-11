class Main{
	void quickSort(int arr[]){
        qSort(arr, 0, arr.length-1);
        int i;
        for(i=0;i<arr.length;i++)
        	System.out.print(arr[i]);
        System.out.println();
    }



	void qSort(int arr[], int low, int high){
	    if (low<high){ 
	      int pi=partition(arr, low, high); 
	      qSort(arr, low, pi-1); 
	      qSort(arr, pi+1, high); 
	    }
	}



	int partition(int arr[], int low, int high){ 
	    int pivot=arr[high];  
	    int i=(low-1);
	    for(int j=low;j<high;j++){ 
	      if (arr[j]<pivot){ 
	        i++; 
	        int temp=arr[i]; 
	        arr[i]=arr[j]; 
	        arr[j]=temp; 
	      } 
	    }
	    int temp=arr[i+1]; 
	    arr[i+1]=arr[high]; 
	    arr[high]=temp; 
	    return i+1; 
	}

	public static void main(String[] args){
		Main a = new Main();
		int arr[] = {2,8,6,0,4,9};
		a.mergeSort(arr);
	}
}