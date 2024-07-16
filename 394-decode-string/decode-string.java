class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        
       
        for(char ch : s.toCharArray()){
            if(ch!=']'){
                st.push(ch);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())){
                    sb.insert(0, st.pop());
                }
                String sub = sb.toString();
                st.pop();

                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0, st.pop());
                }
                int count = Integer.valueOf(sb.toString());

                while(count>0){
                    for(char c :sub.toCharArray()){
                        st.push(c);
                    }
                    count--;
                }

            }
        }
        StringBuilder ret = new StringBuilder();
        while(!st.isEmpty()){
            ret.insert(0, st.pop());
        }

        return ret.toString();

    }
}