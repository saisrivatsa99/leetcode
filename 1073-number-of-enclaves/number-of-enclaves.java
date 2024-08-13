class Solution {
    int m;
    int n;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            if(grid[0][i] == 1)
                dfs(grid, 0, i);
        }

        for(int i = 0 ; i < n; i++){
            if(grid[m-1][i] == 1)
                dfs(grid, m-1, i);
        }
        
        for(int i = 0 ; i < m ; i++){
            if(grid[i][0] == 1)
                dfs(grid, i, 0);
        }

        for(int i = 0 ; i < m ; i++){
            if(grid[i][n-1] == 1)
                dfs(grid, i, n-1);
        }

        int count = 0;
        for(int i = 0 ; i < m;i++){
            for(int j = 0 ; j < n ; j++){
                count += grid[i][j];
                //only unreachable 1's are left.
            }
        }
        return count;
    }
    

    private void dfs(int[][] grid, int x, int y) {
        // Out of bound
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        // Not a land or visited
        if (grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;

        //check all boundaries;
        dfs(grid, x+1, y);//down
        dfs(grid, x-1, y);//up
        dfs(grid, x, y+1);//right
        dfs(grid, x, y-1);//left

    }
    
    
}