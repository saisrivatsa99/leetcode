class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        if(totalSum%2!=0) return false;
        else{
            int k = totalSum/2;
            int[][] dp = new int[n][k+1];
            for(int[] row : dp){
                Arrays.fill(row, -1);
            }
            return helper(n-1, k, dp, nums);
        }
    }

    public boolean helper(int i, int target, int[][] dp, int[] nums){
        if(target ==0) return true;
        if(i==0) return nums[i]==target;
        if(dp[i][target] != -1) {
            return dp[i][target] ==0? false : true;
        }
        boolean notTaken = helper(i-1, target, dp, nums);
        boolean taken = false;
        if(nums[i]<=target){
            taken = helper(i-1, target - nums[i], dp, nums);
        }
        dp[i][target] = taken || notTaken ? 1 :0;
        return taken|| notTaken;
    }
}