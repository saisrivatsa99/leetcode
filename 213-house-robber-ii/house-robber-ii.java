class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }

    public int helper(int[] nums, int start, int end){
        int prev = 0;
        int prev2 = 0;
        for(int i= start; i<end; i++){
            int res = Math.max(prev2+nums[i], prev);
            prev2 = prev;
            prev = res;
        }
        return prev;
    }
}