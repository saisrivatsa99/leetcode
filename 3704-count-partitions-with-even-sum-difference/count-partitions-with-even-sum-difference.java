class Solution {
    public int countPartitions(int[] nums) {
        int rsum =0, n= nums.length, lsum =0, count =0;
        for(int i: nums) rsum +=i;
        for(int i=0; i<n-1; i++){
            lsum += nums[i];
            rsum-=nums[i];
            if((lsum%2)==(rsum%2)) count++;
        }
        return count;
    }
}