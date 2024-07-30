class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans =1;
        for(int i =0; i<nums.length; i++){
            int max =1;
            for(int j=i; j>=0; j--){
                if(nums[j]<nums[i]) max = Math.max(dp[j]+1, max);
            }
            dp[i]= max;
            ans = Math.max(ans, max);
        } 
        return ans;
    }
    
}