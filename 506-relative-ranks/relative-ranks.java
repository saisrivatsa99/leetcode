class Solution {
    public String[] findRelativeRanks(int[] score) {
            int[][] scoreWithIndex = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            scoreWithIndex[i][0] = score[i]; // The score
            scoreWithIndex[i][1] = i; // The original index
        }

        // Sort the array in descending order based on the score
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        // Initialize the result array
        String[] res = new String[score.length];

        // Assign ranks based on sorted order
        for (int i = 0; i < scoreWithIndex.length; i++) {
            int idx = scoreWithIndex[i][1]; // Original index
            if (i == 0) {
                res[idx] = "Gold Medal";
            } else if (i == 1) {
                res[idx] = "Silver Medal";
            } else if (i == 2) {
                res[idx] = "Bronze Medal";
            } else {
                res[idx] = String.valueOf(i + 1);
            }
        }

        return res;
    }
}