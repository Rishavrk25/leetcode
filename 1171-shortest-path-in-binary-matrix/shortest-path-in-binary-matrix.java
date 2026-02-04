class Solution {
    public int shortestPathBinaryMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        if(arr[0][0]!=0 || arr[n-1][m-1]!=0) return -1;
        // boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        // visited[0][0]=true;
        int direction[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int dist[][] = new int[n][m];
        for(int a[]:dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0]=1;
        while(!q.isEmpty()){
            int p[] = q.remove();
            int i=p[0];
            int j=p[1];
            for(int dir[]:direction){
                int ni = i+dir[0];
                int nj = j+dir[1];
                if(ni<0 || nj<0 || ni>=n || nj>=m || arr[ni][nj]!=0) continue;
                if(dist[i][j] + 1 < dist[ni][nj]){
                    dist[ni][nj] = dist[i][j] + 1;
                    q.add(new int[]{ni,nj});
                }
            }
        }
        if(dist[n-1][m-1]==Integer.MAX_VALUE) return -1;
        else return dist[n-1][m-1];
    }
}