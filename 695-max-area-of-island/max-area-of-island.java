class Solution {
    int dfs(int arr[][],int i,int j,boolean visited[][]){
        int m=arr.length;
        int n=arr[0].length;
        visited[i][j]=true;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        int c=0;
        for(int d[]:dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && arr[ni][nj]==1){
                c += 1+dfs(arr,ni,nj,visited);
            }
        }
        return c;
    }
    public int maxAreaOfIsland(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int ans = 0;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    ans = Math.max(ans,1+dfs(arr,i,j,visited));
                }
            }
        }
        return ans;
        
    }
}