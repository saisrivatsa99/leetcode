class Pair {
    int timestamp;
    String val;
    Pair(int timestamp, String val){
        this.timestamp = timestamp;
        this.val = val;
    }
}

class TimeMap {
    private HashMap<String, ArrayList<Pair>> hmp;
    public TimeMap() {
        hmp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hmp.containsKey(key)){
            hmp.get(key).add(new Pair(timestamp, value));
        }else{
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(timestamp, value));
            hmp.put(key, arr);
        }
    }
    
    public String get(String key, int timestamp) {
        String ret = "";
        if(hmp.containsKey(key)){
            ArrayList<Pair> arr= hmp.get(key);
            int low=0, high = arr.size()-1; 
            while(low<= high){
                int mid = (low+high)/2;
                int timeval = arr.get(mid).timestamp;
                if(timeval == timestamp){
                    return arr.get(mid).val;
                }
                else if(timeval<timestamp){
                    ret = arr.get(low).val;
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return ret;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */