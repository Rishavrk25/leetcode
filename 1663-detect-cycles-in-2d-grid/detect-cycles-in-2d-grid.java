class Solution {
    boolean dfs(char arr[][],int i,int j,int pi,int pj,boolean vis[][],int size){
        int m=arr.length;
        int n=arr[0].length;
        vis[i][j]=true;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int d[] : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && arr[ni][nj]==arr[i][j]){
                if(!vis[ni][nj]){
                    if(dfs(arr,ni,nj,i,j,vis,size+1)) return true;
                }
                else{
                    if(ni!=pi && nj!=pj) return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(arr,i,j,-1,-1,vis,1)) return true;
                }
            }
        }
        return false;
    }
}