class Solution {
    /* BFS code
    public boolean bfs(int[][] graph, int[] check, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int dest : graph[curr]){
                if(check[dest]==-1){
                    check[dest] = 1 - check[curr];
                    q.add(dest);
                }else if(check[dest] == check[curr]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] check = new int[graph.length];
        Arrays.fill(check, -1);

        for(int i=0; i<graph.length; i++){
            if(check[i]==-1){
                if(!bfs(graph,check, i)) return false;
            }
        }
        return true;
    }
    */

    public boolean dfs(int[][] graph, int[] check, int start, int color){
        check[start] = color;
        for(int i : graph[start]){
            if(check[i]==-1){
                if(!dfs(graph, check, i, 1-color)) return false;
            }
            else if(check[i]==color) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] check = new int[graph.length];
        Arrays.fill(check, -1);

        for(int i=0; i<graph.length; i++){
            if(check[i]==-1){
                if(!dfs(graph,check, i, 0)) return false;
            }
        }
        return true;
    }
}