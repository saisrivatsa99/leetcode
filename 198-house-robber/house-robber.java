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
        int dp[] = new int[n];
        dp[0] = nums[0];
        
        if(n==1){
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1]);
        }
        return dp[n-1];
    }
}