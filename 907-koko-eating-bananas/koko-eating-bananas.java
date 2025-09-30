class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1, hi= (int)1e9;
        while(low<hi){
            int mid = (low+hi)/2;
            if(!canFinish(piles, mid, h)){
                low = mid+1;
            }else{
                hi = mid;
            }
        }
        return low;
    }

    private boolean canFinish(int[] piles, int mid, int h){
        int hours=0;
        for(int pile: piles){
            hours += (pile + mid -1)/mid;
        }
        return hours<=h;
    }
}