// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.


class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0)
            return false;
        while(num!=1)
        {
            if(num % 4 != 0)
                return false;
            num = num/4;
        }
        if(num == 1)
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        Solution a = new Solution();
        
        System.out.println(a.isPowerOfFour(64));
        
    }
}