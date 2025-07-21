class Solution {
    public String makeFancyString(String s) {
        char[] st = s.toCharArray();
        int c=1, pos=1;
        char ch = st[0];
       
        for(int i=1; i<st.length; i++){
            if(ch!=st[i]){
                c=0;
                ch = st[i]; 
            }
            if(++c >2) continue;
            st[pos++] = st[i];
        }
        return new String(st, 0, pos); 
    }
}