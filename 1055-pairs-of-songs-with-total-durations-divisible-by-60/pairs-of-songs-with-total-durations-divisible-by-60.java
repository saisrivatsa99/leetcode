class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long[] map = new long[60];
        for (int t : time)
            map[t % 60]++;

        long cnt = 0;

        cnt += (((map[0] - 1) * map[0]) / 2);
        cnt += (((map[30] - 1) * map[30]) / 2);

        for (int i = 1; i < 30; i++) {
            cnt += map[i] * map[60 - i];
        }

        return (int) cnt;
    }
}