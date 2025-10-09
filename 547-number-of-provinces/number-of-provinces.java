class Solution {
    private void dfs(int[][] isConnected, boolean[] vis, int node){
        vis[node] = true;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[node][j]==1 && !vis[j]){
                dfs(isConnected, vis, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int c=0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                c++;
            }
        }
        return c;
    }
}