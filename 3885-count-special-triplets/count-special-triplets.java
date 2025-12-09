class Solution {
    public int specialTriplets(int[] nums) {
        int count =0, mod = 1000000007;
        Map<Integer,Integer> left = new HashMap(), right = new HashMap();
        for(int a: nums){
            right.put(a, right.getOrDefault(a,0)+1);
        }

        for(int a: nums){
            right.put(a, right.get(a)-1);
            int ci = left.getOrDefault(a*2,0);
            int ck = right.getOrDefault(a*2,0);
            count = (int)((count+1L*ci*ck)%mod);
            left.put(a, left.getOrDefault(a,0)+1); 
        }
        return count;

        /*
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k= j+1; k<n; k++){
                    if(nums[i]== nums[j]*2 && nums[k]== nums[j]*2) count++;
                }
            }
        }
        return count;
        */
    }
}