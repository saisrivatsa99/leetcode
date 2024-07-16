class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] curr: intervals){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1]< curr[0] )
                mergedIntervals.add(curr);
            else{
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], curr[1]);
            }
        }

        return mergedIntervals.toArray(new int[0][]);
    }
}