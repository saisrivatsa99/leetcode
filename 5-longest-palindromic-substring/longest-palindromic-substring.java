class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max =0;
        String res ="";
        Boolean[][] memo = new Boolean[n][n];
        for(int i=0; i< n; i++){
            for(int j =i; j<n; j++){
                if(s.charAt(i)== s.charAt(j) && isPalin(s, i+1, j-1, memo)){
                    if(max < j-i+1){
                        max = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;

    }

    Boolean isPalin(String s, int i, int j, Boolean[][] memo){
        if(i>=j) return true;
        if(memo[i][j]!= null) return memo[i][j];
        if(s.charAt(i)!=s.charAt(j)){
            memo[i][j] = false;
            return memo[i][j];
        }
        if(j-i<=2){
            memo[i][j] = true;
            return memo[i][j];
        }
        memo[i][j] = isPalin(s, i+1, j-1, memo);
        return memo[i][j];
    }
}