class Solution{
	void selectionSort(int[] array){
		int i,j,tmp;
	    for(i=0;i<array.length-1;i++)
	    {
	      int min = i;
	      for(j=i+1;j<array.length;j++)
	      	min=(array[j]<array[min])?j:min;
	      int tmp=array[i];
	      array[i]=array[min];
	      array[min]=tmp;
	    }

	    for(i =0; i<array.length;i++)
	      System.out.print(array[i]);
	    System.out.println();
    }

    public static void main(String[] args){
      Solution a = new Solution();
      int arr[] = {5,9,0,7,3,2};
      a.selectionSort(arr);
    }
}