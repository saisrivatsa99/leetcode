class Solution {
    public int majorityElement(int[] nums) {
        int cand =-1, count =0;
        for(int n : nums){
            if(count ==0){
                cand = n;
            }
            if(cand ==n){
                count++;
            }else{
                count--;
            }
        }
        return cand;
    }
}