class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        if(l==1) return false;
        for(char ch : s.toCharArray()){
            
            if(ch =='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if(ch==')' && top=='(') st.pop();
                else if(ch==']' && top=='[') st.pop();
                else if(ch=='}' && top=='{') st.pop();
                else return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}