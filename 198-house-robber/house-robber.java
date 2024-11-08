class Solution {
    /*
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length-1);
        
    }
    public int rob(int[] nums, int i){
        if(i<0) return 0;

        if(memo[i]>=0) return memo[i];
        int result = Math.max(rob(nums, i-2)+nums[i], rob(nums, i-1));
        memo[i] = result;
        return memo[i];
    }*/
    public int rob(int[] nums){
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            if(i<0) return 0;
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notPicked = dp[i-1];
            dp[i] = Math.max(pick, notPicked);
        }
        return dp[nums.length-1];
    }
}