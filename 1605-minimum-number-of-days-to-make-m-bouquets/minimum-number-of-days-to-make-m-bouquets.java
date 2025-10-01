class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if((long) m*k>bloomDay.length) return -1;
        int low =1, hi = (int)1e9;
        while(low<hi){
            int mid = low+(hi-low)/2;
            if(isPossible(bloomDay, m,k,mid)){
                hi=mid;
            } else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isPossible(int[] bloomDay, int m, int k, int day){
        int total =0;
        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= day) {
                count++;
                i++;
            }

            if (count == k) {
                total++;
                i--;
            }

            if (total >= m) {
                return true;
            }
        }

        return false;
    }
}