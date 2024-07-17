class RandomizedSet {
    HashMap<Integer, Integer> hm;
    ArrayList<Integer> al;
    Random rand = new Random();
    public RandomizedSet() {
        this.hm = new HashMap<>();
        this.al = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        hm.put(val, al.size());
        al.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int pos = hm.get(val);
        if(pos != al.size()-1){
            int ele= al.get(al.size()-1);
            al.set(pos, ele);
            hm.put(ele, pos);
        }
        hm.remove(val);
        al.remove(al.size()-1);
        return true;
    }
    
    public int getRandom() {
        int randomval=rand.nextInt(al.size());
        return al.get(randomval);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */