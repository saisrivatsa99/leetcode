class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int suma  = 0;
        int ans=0;
        for(int a: apple){
            suma+=a;
        }
        Arrays.sort(capacity); 
        for (int i = 0; i < capacity.length / 2; i++) {
            int temp = capacity[i];
            capacity[i] = capacity[capacity.length - 1 - i];
            capacity[capacity.length - 1 - i] = temp;
        }
        
        for(int c : capacity){
            ans++;
            suma-=c;
            if(suma<=0) break;
        }
        return ans;

    }
}