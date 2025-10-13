class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fc =0;
        Queue<int[]> rotten = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    rotten.offer(new int[] {i,j});
                }
                if(grid[i][j]==1) fc++;
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int rottenTime=0;
        int madeRotten =0;

        while(!rotten.isEmpty() && fc>0){
            rottenTime++;
            int queueSize = rotten.size();
            for(int i=0; i<queueSize; i++){
                int[] curr = rotten.poll();
                int x= curr[0];
                int y = curr[1];
                for(int j=0;j<4; j++){
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];
                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        rotten.offer(new int[]{nx,ny});
                        fc--;
                    }
                }
            }
        }
        return fc==0? rottenTime :-1;
    }
}