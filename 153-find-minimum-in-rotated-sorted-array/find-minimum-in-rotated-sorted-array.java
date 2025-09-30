class Solution {
    public int findMin(int[] nums) {
        int l=0, h= nums.length-1;
        while(l<h){
            int mid = l+ (h-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid] >= nums[l] && nums[mid]>nums[h]){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return nums[l];
    }
}