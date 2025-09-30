class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length ==1) return 0;
        int n = nums.length;
        if(nums[n-1]>nums[n-2]) return n-1;
        if(nums[0]>nums[1]) return 0;
        
        int l =1;
        int r = n-2;
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]>nums[m-1] && nums[m]>nums[m+1]) return m;
            else if(nums[m]< nums[m-1]) r = m-1;
            else if(nums[m]<nums[m+1]) l = m+1;
        }
        return -1;
    }
}