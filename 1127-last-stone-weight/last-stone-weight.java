class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones){
            pq.add(n);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a>b){
                pq.add(a-b);
            }
        }
        if(pq.size()==0){
            return 0;
        }
        return pq.peek();
    }
}