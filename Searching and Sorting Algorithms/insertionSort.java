class Solution{
  void insertionSort(int[] array){
    int i, j, key;
    for(i=1;i<array.length;i++){
      key=array[i];
      j=i-1;
      while(j>=0&&array[j]>key){ 
        array[j+1]=array[j]; 
        j--; 
      } 
      array[j+1]=key;
    }

    for(i =0; i<array.length;i++)
      System.out.print(array[i]);
    System.out.println();
  }

  public static void main(String[] args){
    Solution a = new Solution();
    int arr[] = {5,9,0,7,3,2};
    a.insertionSort(arr);
  }
}
