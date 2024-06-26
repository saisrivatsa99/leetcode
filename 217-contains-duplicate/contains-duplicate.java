class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> m = new HashMap();

        for(int n : nums){
            if(m.containsKey(n)){
                return true;
            }
            m.put(n, m.getOrDefault(n,0));
        }
        return false;
    }
}