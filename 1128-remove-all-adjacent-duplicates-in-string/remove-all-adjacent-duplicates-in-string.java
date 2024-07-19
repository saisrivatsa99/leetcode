class Solution {
    public String removeDuplicates(String s) {
        /*
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for(char ch: str){
            if(!st.isEmpty()){
                if(st.peek()==ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }else{
                st.push(ch);
            }
            
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
        */
        char[] st = s.toCharArray();
        int top =-1;
        for(char ch: st){
            if(top>=0 && st[top]==ch){
                top--;
            }
            else{
                st[++top] = ch;
            }
        }

        return new String(st, 0, top+1);
    }
}