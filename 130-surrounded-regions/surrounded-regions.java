class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        int[][] vis = new int[m][n];

        for(int j=0; j<n; j++){
            if(board[0][j]=='O' && vis[0][j]==0){
                dfs(board, vis, 0, j, delRow, delCol);
            }
            if(board[m-1][j]=='O' && vis[m-1][j]==0){
                dfs(board, vis, m-1, j, delRow, delCol);
            }
        }

        for(int j=0; j<m; j++){
            if(board[j][0]=='O' && vis[j][0]==0){
                dfs(board, vis, j, 0, delRow, delCol);
            }
            if(board[j][n-1]=='O' && vis[j][n-1]==0){
                dfs(board, vis, j, n-1, delRow, delCol);
            }
        }

        for(int i = 0;i<m;i++) {
            for(int j= 0 ;j<n;j++) {
                if(vis[i][j] == 0 && board[i][j] == 'O') 
                    board[i][j] = 'X'; 
            }
        }

    }

    public void dfs(char[][] board, int[][] vis, int row, int col, int[] delRow, int[] delCol){
        vis[row][col] = 1;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0;i<4;i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i]; 
            if(nrow >=0 && nrow <m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(board, vis, nrow, ncol, delRow, delCol); 
            }
        }
    }

}