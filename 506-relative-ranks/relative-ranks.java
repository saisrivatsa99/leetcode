class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> m = new HashMap<>();
        PriorityQueue<Integer> p = new PriorityQueue(Collections.reverseOrder());
        int rank=0;
        String[] ans = new String[score.length];
        for(int i=0; i<score.length; i++){
            m.put(score[i], i);
            p.add(score[i]);
        }
        while(p.size()!=0){
            rank++;
            int s = p.remove();
            if(rank ==1){
                ans[m.get(s)] = "Gold Medal";
            }
            else if(rank ==2){
                ans[m.get(s)] = "Silver Medal";
            }
            else if(rank ==3){
                ans[m.get(s)] = "Bronze Medal";
            }
            else{
                ans[m.get(s)] = Integer.toString(rank);
            }
        } 
        return ans;
    }
}