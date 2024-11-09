class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        } 
        return helper(0, 0, dp, triangle);
    }

    public int helper(int i, int j, int[][] dp, List<List<Integer>> triangle){
        if(dp[i][j]!=-1) return dp[i][j];

        if(i== dp.length -1) return triangle.get(i).get(j);
        int down = triangle.get(i).get(j) + helper(i+1, j, dp, triangle);
        int crossDown = triangle.get(i).get(j) + helper(i+1, j+1, dp, triangle);

        return dp[i][j]= Math.min(down, crossDown);
    }
}