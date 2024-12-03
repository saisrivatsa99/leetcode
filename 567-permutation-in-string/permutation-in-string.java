class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] cs1 = new int[26];
        int[] cs2 = new int[26];
        for(int i=0; i<m; i++){
            cs1[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<n; i++){
            if(i>=m){
                cs2[s2.charAt(i-m) -'a']--;
            }
            cs2[s2.charAt(i)- 'a']++;
            if(Arrays.equals(cs1,cs2)){
                return true;
            }
        }
        return false;

    }
}