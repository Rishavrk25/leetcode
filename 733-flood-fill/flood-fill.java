class Solution {
       void dfs(int arr[][],int i,int j,int newColor,int oldColor){
        int n=arr.length;
        int m=arr[0].length;
        if(i<0 || i>=n || j<0 || j>=m || arr[i][j]!=oldColor) return;
        arr[i][j]=newColor;
        int direction[][]={{0,1},{0,-1},{1,0},{-1,0}};
        for(int dir=0;dir<4;dir++){
            int i_ = i + direction[dir][0];
            int j_ = j + direction[dir][1];
            dfs(arr,i_,j_,newColor,oldColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}