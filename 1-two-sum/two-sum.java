class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> ans = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(ans.containsKey(nums[i])){
                result[0] = i;
                result[1]= ans.get(nums[i]);
            }
            else{
                ans.put(target-nums[i], i);
            }
        }
        return result;
    }
}