class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n + 1][target + 1];

        return helper(nums, n, target, 0, dp);
    }

    private boolean helper(int[] nums, int n, int target, int idx, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (target < 0 || idx >= n - 1) {
            return false;
        }

        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        return dp[idx][target] = helper(nums, n, target - nums[idx + 1], idx + 1, dp) || helper(nums, n, target, idx + 1, dp);
    }


}