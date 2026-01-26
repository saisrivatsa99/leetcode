class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDif = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1; i<n; i++){
            int diff = arr[i] - arr[i-1];
            if(diff<minDif){
                minDif = diff;
                res = new ArrayList();
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == minDif) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}