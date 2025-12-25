class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count =0, n = happiness.length;
        long ans =0;
        for(int i=n-1; i>= n-k; i--){
            if(happiness[i]+count>0) ans += (long)(happiness[i]+count) ;
            count--;
        }
        return ans;
    }

}