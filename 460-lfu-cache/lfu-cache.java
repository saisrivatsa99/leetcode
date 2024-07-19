class LFUCache {
    Map<Integer, Integer> keyFreq = new HashMap<>();
    Map<Integer, Integer> keyVal = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> LRUTracker = new HashMap<>();
    private int capacity;
    private int minFreq =0;

    public LFUCache(int capacity) {
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        if(!keyVal.containsKey(key)) return -1;
        final int freq = keyFreq.get(key);
        LRUTracker.get(freq).remove(key);
        if(freq == minFreq && LRUTracker.get(freq).isEmpty()){
            LRUTracker.remove(freq);
            minFreq++;
        }
        putFreq(key, freq+1);
        return keyVal.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity ==0) return;
        if(keyVal.containsKey(key)){
            keyVal.put(key, value);
            get(key);
            return;
        }

        if(keyVal.size() == capacity){
            final int keyToEvict = LRUTracker.get(minFreq).iterator().next();
            LRUTracker.get(minFreq).remove(keyToEvict);
            keyVal.remove(keyToEvict);
        }
        minFreq =1;
        putFreq(key, minFreq);
        keyVal.put(key, value);
    }

    private void putFreq(int key, int freq){
        keyFreq.put(key, freq);
        LRUTracker.putIfAbsent(freq, new LinkedHashSet<>());
        LRUTracker.get(freq).add(key);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */