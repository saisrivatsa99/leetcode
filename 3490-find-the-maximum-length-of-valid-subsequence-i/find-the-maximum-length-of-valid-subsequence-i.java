class Solution {
    public int maximumLength(int[] nums) {
        int countEven =0;
        int countOdd=0;
        for(int num : nums){
            if(num%2==0) countEven++;
            else countOdd++;
        }
        int evendp =0;
        int odddp =0;
        for(int num: nums){
            if(num%2==0){
                evendp = Math.max(evendp, odddp+1);
            } else {
                odddp = Math.max(odddp, evendp+1);
            }
        }
        return Math.max(Math.max(countOdd,countEven), Math.max(evendp,odddp));
    }
}