// Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

//"A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
 
        int result = 0;
        for(int i=citations.length-1; i>=0; i--){
            int cnt = citations.length-i;
            if(citations[i]>=cnt){
                result = cnt;
            }else{
                break;
            }
        }

        return result;
    }
}