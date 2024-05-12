class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        if(amount ==0) return 0;
        if(coins == null || coins.length==0 || amount<0) return -1;
        int ans = ways(coins, amount, dp); 
        return ans==Integer.MAX_VALUE? -1: ans ;
    }

    public int ways(int[] coins, int amount, int[] dp){
        int ans=Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[amount]>0) return dp[amount];
        for(int c: coins){
            if(c<=amount){
                int count = ways(coins, amount-c, dp);
                if(count!= Integer.MAX_VALUE){
                    ans = Math.min(ans, count+1);
                }
                
            }
        }
        dp[amount] = ans;
        return ans;
    }
}