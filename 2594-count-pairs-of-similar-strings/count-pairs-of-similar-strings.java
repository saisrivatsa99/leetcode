class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (freq[index] == 0)
                    freq[index] = 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<26; i++) {
                if (freq[i] == 1) 
                    sb.append(i);
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) >= 2)
                count += map.get(key) * (map.get(key) - 1) / 2;
        }
        return count;
    }
}