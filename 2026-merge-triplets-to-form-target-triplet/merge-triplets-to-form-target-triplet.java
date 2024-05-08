class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        boolean a = false, b = false, c = false;
        for (int i = 0; i < n; i++) {
            if (triplets[i][0] > target[0]) continue;
            if (triplets[i][1] > target[1]) continue;
            if (triplets[i][2] > target[2]) continue;
            if (triplets[i][0] == target[0]) a = true;
            if (triplets[i][1] == target[1]) b = true;
            if (triplets[i][2] == target[2]) c = true;
            if (a && b && c) return true;
        }
        return false;
    }
}