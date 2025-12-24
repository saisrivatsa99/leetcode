class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int suma  = 0;
        int ans=0;
        for(int a: apple){
            suma+=a;
        }
        Arrays.sort(capacity); 

        for(int i= capacity.length-1; i>=0; i--){
            ans++;
            suma-= capacity[i];
            if(suma<=0) break;
        }
        return ans;

    }
}