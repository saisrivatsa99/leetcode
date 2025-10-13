class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];
        if(oc!=color){
            dfs(image, sr, sc, oc, color);
        }
        return image;
    }

    public static void dfs(int[][] image, int i, int j, int oc, int color){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=oc) return;
        image[i][j] = color;

        dfs(image, i-1, j, oc, color);
        dfs(image, i, j-1, oc, color);
        dfs(image, i+1, j, oc, color);
        dfs(image, i, j+1, oc, color);
    }
}