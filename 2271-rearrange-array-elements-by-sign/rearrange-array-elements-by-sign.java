class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pi = 0;   // pointer for positive numbers
        int ni = 1;   // pointer for negative numbers
        int[] res = new int[nums.length];

        for (int n : nums) {
            if (n > 0) {
                res[pi] = n;
                pi += 2;
            } else {
                res[ni] = n;
                ni += 2;
            }
        }

        return res;
    }
}