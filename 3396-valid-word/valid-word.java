class Solution {
    private static final String VOWELS = "aeiouAEIOU";
    public boolean isValid(String word) {
        
        if(word.length()<3) return false;
        int vc=0, cc=0;
        for(char ch : word.toCharArray()){
            if(Character.isDigit(ch)) continue;
            if(Character.isLetter(ch)){
                if(VOWELS.indexOf(ch)>=0) ++vc;
                else ++cc;
            }else{
                return false;
            }
        }
        return vc>0 & cc>0;
    }
}