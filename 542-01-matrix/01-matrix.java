class Solution {
    public int[][] updateMatrix(int[][] mat) {
        class Pair{
            int row;
            int col;
            Pair(int row, int col){
                this.row = row;
                this.col = col;
            }
        }

        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] ans= new int[n][m];
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                    ans[i][j]=0;
                } 
                else{
                    ans[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;

            if(isValid(row,col+1,n,m) && ans[row][col+1]==-1 ){
                q.offer(new Pair(row, col+1));
                ans[row][col+1] = ans[row][col]+1;
            }
            if(isValid(row+1,col,n,m) && ans[row+1][col]==-1 ){
                q.offer(new Pair(row+1, col));
                ans[row+1][col] = ans[row][col]+1;
            }
            if(isValid(row,col-1,n,m) && ans[row][col-1]==-1 ){
                q.offer(new Pair(row, col-1));
                ans[row][col-1] = ans[row][col]+1;
            }
            if(isValid(row-1,col,n,m) && ans[row-1][col]==-1 ){
                q.offer(new Pair(row-1, col));
                ans[row-1][col] = ans[row][col]+1;
            }
        }
        return ans;
    }

    public boolean isValid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m) return false;
        return true;
    }
}