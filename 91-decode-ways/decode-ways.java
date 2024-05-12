class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s,0,dp);
    }
    public int decode(String s,int i,int[]dp){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0; 
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ways = decode(s, i + 1,dp);

        if (i < s.length() - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
            ways += decode(s, i + 2,dp);
        }
        dp[i] = ways;
        return ways;
    }
}