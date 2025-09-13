class Solution {
    public boolean isPalindrome(String s) {
        /*
        String alp = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(alp).reverse().toString();
        return alp.equals(reversed);
        */

        //recursive approach
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return recPal(0,s);
    }

    private boolean recPal(int i, String s){
        if(i>=s.length()/2) return true;
        if(s.charAt(i)!= s.charAt(s.length()-i-1)) return false;
        return recPal(i+1,s);
    }
}