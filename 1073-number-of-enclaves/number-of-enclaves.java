class Solution {
    public int numEnclaves(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && arr[i][j]==1){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int direction[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int p[] = q.remove();
            for(int dir[] : direction){
                int i_ = p[0]+dir[0];
                int j_ = p[1]+dir[1];
                if(i_<0 || i_>=n || j_<0 || j_>=m || visited[i_][j_] || arr[i_][j_]!=1) continue;
                q.add(new int[]{i_,j_});
                visited[i_][j_]=true;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && arr[i][j]==1) ans++;
            }
        }
        return ans;
    }
}