class Solution {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if(m!=n) return false;
        if(s.equals(goal)) return true;
        return (s+s).contains(goal);
        
    }
}