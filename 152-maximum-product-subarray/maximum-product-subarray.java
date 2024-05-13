class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, temp=1;
        for(int i : nums){
            temp*= i;
            max = Math.max(temp, max);
            if(temp==0) temp=1;
        }
        temp=1;
        for(int i = nums.length-1; i>=0; i--){
            temp*= nums[i];
            max = Math.max(max, temp);
            if(temp==0) temp=1;
        }
        return max;

    }
}