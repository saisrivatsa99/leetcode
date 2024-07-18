class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer>[] freq = new List[nums.length +1];
        List<Integer> res = new ArrayList();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i,0)+1);
        }

        for(int key : mp.keySet()){
            if(freq[mp.get(key)]== null){
                freq[mp.get(key)] = new ArrayList();
            }
            freq[mp.get(key)].add(key);
        }

        for(int i = freq.length-1; i>=0 && res.size()<k; i--){
            if(freq[i] != null){
                res.addAll(freq[i]);
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}