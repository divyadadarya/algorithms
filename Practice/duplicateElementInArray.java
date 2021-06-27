class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int i;
        for(i=0;i<nums.length;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }
            else{
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args){
        Solution a = new Solution();
        int arr[] = {1,6,7,1};
        boolean s = a.containsDuplicate(arr);
        System.out.println(s);
    }
}