class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int max=0;
        int left =-1;
        if(s.length()==0 || s.length()==1){
            return 0;
        }
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                if(st.isEmpty()) left =i;
                else{
                    st.pop();
                    if(st.isEmpty()) max = Math.max(max, i-left);
                    else max = Math.max(max, i-st.peek());
                }
            }
        }
        return max;

    }
}