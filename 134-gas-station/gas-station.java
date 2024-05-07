class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tgas=0, tcost=0;
        for(int i=0; i<gas.length; i++){
            tgas+= gas[i];
            tcost+= cost[i];
        }   
        if(tgas<tcost) return -1;

        int rgas =0, start=0;
        for(int i=0; i<gas.length; i++){
            rgas = rgas +(gas[i]-cost[i]);
            if(rgas<0){
                start= i+1;
                rgas =0;
            }
        }
        return start;
    }
}