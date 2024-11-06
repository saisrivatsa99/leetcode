class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++){
            if(str[i] == '(' || str[i] =='[' || str[i]=='{'){
                st.push(str[i]);
            }
            else{
                if(st.isEmpty()) return false;
                else if(str[i]==')' && st.peek()=='('){
                    st.pop();
                } else if(str[i]==']' && st.peek()=='['){
                    st.pop();
                } else if(str[i]=='}' && st.peek()=='{'){
                    st.pop();
                } else{
                    return false;
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}