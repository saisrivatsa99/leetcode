public class Solution {
    public int uniquePaths(int m, int n) {
        /*
        Mathematical method:
        in a m*n grid, we have to make m-1 moves down and n-1 moves right to reach arr[m-1][n-1]
        This means we have a total of m+n-2 moves to make. 
        The formula for this is:
        (m+n-2)! / (m-1)!* (n-1)!

        */
        /*
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
            System.out.println(res);
        }
            
        return (int)res;
        */

        /*
        DP method memoization:
        We assume we have answer for ways to reach the last second step and add to it. We have a base case at 0,0 
        where no of ways is 1.
        */

        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1,dp);
    }

    public int helper(int m, int n, int[][]dp){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int up = helper(m-1, n, dp);
        int left = helper(m, n-1, dp);

        return dp[m][n] = up+left;
    } 
}