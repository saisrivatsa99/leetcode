class Solution {

    private static void dfs(int node, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;
        for( int i : adj.get(node)){
            if(vis[i]==0){
                dfs(i, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int m = isConnected.length;
        int n = isConnected[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<m; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(isConnected[i][j]==1) adj.get(i).add(j);
            }
        }

        int[] vis = new int[m];
        for(int i=0; i<m; i++){
            if(vis[i]==0){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;

    }
}