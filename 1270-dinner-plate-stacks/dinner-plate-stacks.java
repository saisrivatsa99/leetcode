class DinnerPlates {
    List<Stack<Integer>> stacks;
    int capacity;
    TreeSet<Integer> availableStack;

    public DinnerPlates(int capacity) {
        this.stacks = new ArrayList<Stack<Integer>>();
        this.capacity = capacity;
        this.availableStack = new TreeSet<Integer>();    
    }
    
    public void push(int val) {
        if(availableStack.isEmpty()){
            stacks.add(new Stack<Integer>());
            availableStack.add(stacks.size()-1);
        }
        Stack<Integer> firstAvailable = stacks.get(availableStack.first());
        firstAvailable.push(val);

        if(firstAvailable.size()== capacity){
            availableStack.pollFirst();
        }
    }
    
    public int pop() {
        if(stacks.isEmpty()) return -1;
        int val = stacks.get(stacks.size()-1).pop();
        availableStack.add(stacks.size()-1);

        while(!stacks.isEmpty() && stacks.get(stacks.size()-1).isEmpty()){
            stacks.remove(stacks.size()-1);
            availableStack.pollLast();
        }
        return val;
    }
    
    public int popAtStack(int index) {
        if(index>= stacks.size()) return -1;
        if(index>= stacks.size()-1) return pop();

        Stack<Integer> requiredStack = stacks.get(index);
        int val = requiredStack.isEmpty()? -1 : requiredStack.pop();
        availableStack.add(index);
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */