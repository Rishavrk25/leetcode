class Solution {
    void dfs(char arr[][],int i,int j,boolean visited[][]){
        int n=arr.length;
        int m=arr[0].length;
        if(i<0 || i>=n || j<0 || j>=m || arr[i][j]!='1' || visited[i][j]) return;
        visited[i][j]=true;
        int directions[][]={{1,0},{-1,0},{0,1},{0,-1}};
        for(int dir=0;dir<4;dir++){
            int i_ = i + directions[dir][0];
            int j_ = j + directions[dir][1];
            dfs(arr,i_,j_,visited);
        }
    }
    public int numIslands(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean visited[][] = new boolean[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && arr[i][j]=='1'){
                    dfs(arr,i,j,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
}