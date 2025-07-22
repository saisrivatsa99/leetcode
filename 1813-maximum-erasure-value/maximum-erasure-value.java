class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10001];
        int left=0;
        int currentsum =0;
        int maxsum =0;

        for(int right =0 ; right< n; right++){
            while(seen[nums[right]]){
                currentsum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            currentsum += nums[right];
            seen[nums[right]]= true;
            maxsum = Math.max(currentsum, maxsum);
        }
        return maxsum;
    }
}