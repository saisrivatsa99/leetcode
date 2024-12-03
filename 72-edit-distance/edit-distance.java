class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return editDistance(word1, word2, m-1, n-1, dp);
    }
    public int editDistance(String word1, String word2, int i, int j, int[][] dp){
        if(i==0 && j==0){
            if(word1.charAt(i)== word2.charAt(j)){
                return 0;
            }
            else{
                return 1;
            }
        }
        
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)== word2.charAt(j)){
            return dp[i][j] = editDistance(word1, word2, i-1, j-1, dp);
        }
        else{
            return dp[i][j] = 1+ Math.min(editDistance(word1, word2, i-1, j-1, dp), Math.min(editDistance(word1, word2, i, j-1, dp), editDistance(word1, word2, i-1, j, dp))) ;
        }
    }
}