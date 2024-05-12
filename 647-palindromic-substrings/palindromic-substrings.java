class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt =0;
        boolean[][] memo = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j =i; j<n; j++){
                if(s.charAt(i)== s.charAt(j)){
                    if(j-i <=2){
                        memo[i][j] = true;
                    }
                    else{
                        memo[i][j] = memo[i+1][j-1];
                    }
                }
                if(memo[i][j] ==true){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}