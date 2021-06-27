class Solution{
  void bubbleSort(int[] array)
  {
    int i,j,tmp;
    for(i=0;i<array.length;i++)
    {
      for(j=0;j<array.length-i-1;j++)
      {
        if(array[j]>array[j+1])
        {
          tmp=array[j];
          array[j]=array[j+1];
          array[j+1]=tmp;
        }
      }
    }

    for(i =0; i<array.length;i++)
      System.out.print(array[i]);
    System.out.println();
  }

  public static void main(String[] args){
      Solution a = new Solution();
      int arr[] = {5,9,0,7,3,2};
      a.bubbleSort(arr);
  }
}

