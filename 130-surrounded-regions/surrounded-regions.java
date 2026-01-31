class Solution {
    void bfs(char arr[][],int i,int j,boolean visited[][]){
        int n=arr.length;
        int m=arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        int direction[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int p[] = q.remove();
            for(int dir=0;dir<4;dir++){
                int i_=p[0]+direction[dir][0];
                int j_=p[1]+direction[dir][1];
                if(i_<0 || i_>=n || j_<0 || j_>=m || visited[i_][j_] || arr[i_][j_]!='O') continue;
                q.add(new int[]{i_,j_});
                visited[i_][j_]=true;
            }
        }
    }
    public void solve(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            // first col
            if(arr[i][0]=='O' && !visited[i][0]) bfs(arr,i,0,visited);
            // last col
            if(arr[i][m-1]=='O' && !visited[i][m-1]) bfs(arr,i,m-1,visited);
        }
        for(int j=0;j<m;j++){
            // first row
            if(arr[0][j]=='O' && !visited[0][j]) bfs(arr,0,j,visited);
            // last row
            if(arr[n-1][j]=='O' && !visited[n-1][j]) bfs(arr,n-1,j,visited);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]) arr[i][j]='X';
            }
        }

    }
}