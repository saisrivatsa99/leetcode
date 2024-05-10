class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (x, y) -> Double.compare((double) y[0] / y[1], (double) x[0] / x[1]));
        for(int i=0; i<arr.length; i++){
            for(int j= i+1; j< arr.length; j++){
                pq.add(new int[] {arr[i], arr[j]});
                if(pq.size()>k) pq.poll();
            }
        }
        return pq.peek();
    }
}