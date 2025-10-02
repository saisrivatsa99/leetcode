class Solution {
    public int splitArray(int[] nums, int k) {
        int low =0, high = 0;
        for(int num :nums){
            low = Math.max(low,num);
            high += num;
        }
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isFeasible(nums, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean isFeasible(int[] nums, int k, int mid){
        int cc=1;
        int cs=0;
        for(int num: nums){
            cs += num;
            if(cs>mid){
                cs = num;
                cc++;
                if(cc>k) return false;
            }
        }
        return true;
    }
}