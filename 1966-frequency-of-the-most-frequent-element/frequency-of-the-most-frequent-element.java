class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=0;
        long res=0, total =0;
        while(r< nums.length){
            total += nums[r];
            while(nums[r]*(r-l+1L) > total+k){
                total -=nums[l];
                l+=1;
            }
            res = Math.max(res, r-l+1L);
            r+=1;
        }

        return (int)res;
    }
}