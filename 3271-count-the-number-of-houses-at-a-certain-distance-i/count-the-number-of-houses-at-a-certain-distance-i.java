class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] graph = new int[n][n];
        for( int[] d: graph){
            Arrays.fill(d, 100);
        }
        for(int i=0; i<n-1; i++){
            graph[i][i+1] = 1;
            graph[i+1][i] = 1;
        }
        graph[x-1][y-1] = 1;
        graph[y-1][x-1] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+ graph[i][k]);
                }
            }
        }

        int[] total = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j){
                    total[graph[i][j] -1]++;
                }
            }
        }
        return total;

    }
}