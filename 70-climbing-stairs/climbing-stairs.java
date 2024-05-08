class Solution {
    /*
    public int climbStairs(int n) {
        //Top Down DP - Recursiion + Memoization
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1,1);
        memo.put(2,2);
        return climbStairs(n, memo);
    }

    public int climbStairs(int n, Map<Integer, Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        return memo.get(n);
    }*/

    //Bottom up DP
    public int climbStairs(int n){
        if(n<=1) return 1;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}