class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        if(s.length()!= t.length()) return false;
        
        Map<Character, Integer> m= new HashMap();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for(int i=0; i<s1.length; i++){
            m.put(s1[i], m.getOrDefault(s1[i],0)+1);
            m.put(t1[i], m.getOrDefault(t1[i],0)-1);
        }
        for(Character k : m.keySet()){
            if(m.get(k)!=0) return false;
        } 
        return true;
        */
        if(s.length()!= t.length()) return false;
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}