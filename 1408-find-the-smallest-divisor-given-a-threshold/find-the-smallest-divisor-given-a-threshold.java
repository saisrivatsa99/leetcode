class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1, high=(int)1e6;
        while(low<high){
            int mid = low+(high-low)/2;
            if(check(nums, threshold, mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean check(int[]nums, int th, int m){
        int ans =0;
        for(int n: nums){
            ans += (n+m-1)/m;
        }
        return ans<=th;
    }
}