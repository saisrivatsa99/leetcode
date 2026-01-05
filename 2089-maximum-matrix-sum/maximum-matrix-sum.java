class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        int leastElement = 100001;
        long sum = 0L;
        int negCount =0;

        for(int[] row: matrix){
            for(int val : row){
                if(val<0){
                    negCount++;
                    val = -val;
                }
                sum += val;
                if(val < leastElement){
                    leastElement = val;
                }
            }
        }

        return (negCount%2==0)? sum : (sum - 2*leastElement); 
    }
}