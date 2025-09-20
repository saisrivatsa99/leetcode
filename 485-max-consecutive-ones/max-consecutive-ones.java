class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0, r=0;
        int mc = 0;
        while(r<nums.length){
            if(nums[l]==nums[r] && nums[r]==1){
                mc = Math.max(mc, r-l+1);
                r++;
            }else{
                r++;
                l=r;
            }
        }
        return mc;
    }
}