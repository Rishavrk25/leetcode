class Solution {
    int bfs(int arr[][],int i,int j,boolean visited[][]){
        int n=arr.length;
        int m=arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        int direction[][] = {{0,1},{0,-1},{-1,0},{1,0}};
        int c=1;
        boolean flag = false; // cannot reach edge cells
        while(!q.isEmpty()){
            int p[] = q.remove();
            for(int dir[] : direction){
                int i_ = p[0]+dir[0];
                int j_ = p[1]+dir[1];
                if(i_<0 || i_>=n || j_<0 || j_>=m || visited[i_][j_] || arr[i_][j_]!=1) continue;
                if(i_==0 || j_==0 || i_==n-1 || j_ == m-1) flag = true;
                q.add(new int[]{i_,j_});
                c++;
                visited[i_][j_]=true;
            }
        }
        if(flag==false) return c;
        else return 0;
    }
    public int numEnclaves(int[][] arr) {
         int n=arr.length;
        int m=arr[0].length;
        boolean visited[][] = new boolean[n][m];
        int ans = 0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    ans += bfs(arr,i,j,visited);
                }
            }
        }
        return ans;
    }
}