class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length==0) return new ArrayList<>();
        HashMap<String, List<String>> anaMap= new HashMap();

        for(String s :strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sortedKey = new String(cs);
            anaMap.putIfAbsent(sortedKey, new ArrayList<>());
            anaMap.get(sortedKey).add(s);
        }
        return new ArrayList<>(anaMap.values());
    }
}