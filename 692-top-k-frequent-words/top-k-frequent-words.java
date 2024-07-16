class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();
        for(String word : words) mp.put(word, mp.getOrDefault(word, 0)+1);

        PriorityQueue<String> minHeap = new PriorityQueue<>((s1,s2)->{
            int s1Count = mp.get(s1);
            int s2Count = mp.get(s2);

            if(s1Count == s2Count) return s2.compareTo(s1);
            return s1Count - s2Count;
        });

        for(String word: mp.keySet()){
            minHeap.offer(word);
            if(minHeap.size()>k) minHeap.poll();
        }

        LinkedList<String> res = new LinkedList<>();
        while(!minHeap.isEmpty()) res.addFirst(minHeap.poll());
        return res;
    }
}