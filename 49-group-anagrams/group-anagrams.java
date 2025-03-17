class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs ==null || strs.length==0){
            return new ArrayList<>(); 
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            anagramMap.putIfAbsent(sortedKey, new ArrayList<>());
            anagramMap.get(sortedKey).add(s);
        }
        return new ArrayList<>(anagramMap.values());
    }
}