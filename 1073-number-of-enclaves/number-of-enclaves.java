class Solution {

    public void dfs(int r, int c, int[][] vis, int[][] grid){
        vis[r][c]=1;
        int m = grid.length;
        int n = grid[0].length; 
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow, ncol, vis, grid);
            } 
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        for(int j=0; j<n; j++){
            // first row
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0, j, vis, grid);
            }
            // last row
            if(vis[m-1][j]==0 && grid[m-1][j]==1){
                dfs(m-1, j, vis, grid);
            }
        }

        for(int i=0; i<m; i++){
            // first col
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i, 0, vis, grid);
            }
            // last col
            if(vis[i][n-1]==0 && grid[i][n-1]==1){
                dfs(i, n-1, vis, grid);
            }
        }

        int cnt =0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]==0 && grid[i][j]==1) cnt++;
            }
        }

        return cnt;
    }
}