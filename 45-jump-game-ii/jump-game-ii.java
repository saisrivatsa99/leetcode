class Solution {
    public int jump(int[] nums) {
        int jumps=0, cend=0, cfar=0;
        for(int i=0; i<nums.length-1; i++){
            cfar = Math.max(cfar, i+ nums[i]);
            if(i==cend){
                jumps++;
                cend = cfar;
            }
        }
        return jumps;
    }
}