class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i=0; i<nums.size(); i++){
            int k = nums.get(i), n=1, a = -1;

            while((k&n)!=0){
                a = k-n;
                n<<=1;
            }
            ans[i] = a;
        }
        return ans;
    }
}