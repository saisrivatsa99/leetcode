class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans =0;
        for(int t: time){
            int v = t%60;
            int target = 60-v;
            if(mp.containsKey(target)){
                ans += mp.get(target);
            }
            if(v!=0){
                mp.put(v, mp.getOrDefault(v, 0)+1);    
            }
            else{
                mp.put(60, mp.getOrDefault(60, 0)+1);    
            }
            
        }
        return ans;
    }
}