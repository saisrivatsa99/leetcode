class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] ss = new boolean[128];
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (ss[c]) {
                ss[s.charAt(left)] = false;
                left++;
            }
            ss[c] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
        }
}