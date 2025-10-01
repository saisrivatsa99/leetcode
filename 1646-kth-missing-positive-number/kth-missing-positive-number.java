class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0, r = arr.length;
        while(l<r){
            int m = l+ (r-l)/2;
            int miss = arr[m]-(m+1);
            if(miss >=k){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l+k;
    }
}