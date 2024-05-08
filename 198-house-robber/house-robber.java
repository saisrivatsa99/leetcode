class Solution {
    /*int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length-1);
    }

    public int rob(int[] nums, int i){
        if(i<0) return 0;

        if(memo[i]>=0) return memo[i];
        int result = Math.max(rob(nums, i-2)+nums[i], rob(nums, i-1));
        memo[i] = result;
        return memo[i];
    } */

    public int rob(int[] nums) {
        int n = nums.length;        
        if(n==1){
            return nums[0];
        }
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int dp = Math.max(dp1+ nums[i], dp2);
            dp1 = dp2;
            dp2 = dp;
        }
        return dp2;
    }
}