// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements that appear twice in this array.

// Could you do it without extra space and in O(n) runtime?


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                ans.add(nums[i]);
                i++;
            }
        }
        return ans;
    }

    public static void main() {
    	Solution a = new Solution();
    	int[] arr = new int[]{4,3,2,7,8,2,3,1};
    	System.out.println(a.findDuplicates(arr));
    }
}