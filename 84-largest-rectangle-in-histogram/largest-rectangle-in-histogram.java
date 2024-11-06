class Solution {
    public int largestRectangleArea(int[] A) {
        int leftSmallerArr[] = new int[A.length]; 
        int rightSmallerArr[] = new int[A.length];
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        s1.push(0);
        leftSmallerArr[0] = -1;
        for(int i = 1; i < A.length; i++){
            while(!s1.isEmpty() && A[s1.peek()] >= A[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                leftSmallerArr[i] = -1;
            }else{
                leftSmallerArr[i] = s1.peek();
            }
            s1.push(i);
        }
        
        s2.push(A.length - 1);
        rightSmallerArr[A.length - 1] = A.length;
        for(int i = A.length - 2; i >= 0; i--){
            while(!s2.isEmpty() && A[s2.peek()] >= A[i]){
                s2.pop();
            }
            if(s2.isEmpty()){
                rightSmallerArr[i] = A.length;
            }else{
                rightSmallerArr[i] = s2.peek();
            }
            s2.push(i);
        }

        for(int i = 0; i < A.length; i++){
            System.out.print(leftSmallerArr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < A.length; i++){

            System.out.print(rightSmallerArr[i] + " ");
        }


        
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            ans = Math.max(ans, (rightSmallerArr[i] - leftSmallerArr[i] - 1) * A[i]);
        }
        return ans;
    }
}