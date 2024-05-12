class Solution {
    public int rob(int[] nums) {
        int n = nums.length;        
        if(n==1){
            return nums[0];
        }
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }

    public int helper(int[] nums, int start, int end){
        int dp1=0, dp2=0;
        for(int i = start; i<end; i++){
            int res = Math.max(dp1+nums[i], dp2);
            dp1 = dp2;
            dp2 = res; 
        }
        return dp2;
    }
}