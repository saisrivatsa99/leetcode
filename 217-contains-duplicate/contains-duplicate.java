class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> se = new HashSet();
        for(int n: nums){
            if(!se.add(n)) return true;
        }
        return false;
    }
}