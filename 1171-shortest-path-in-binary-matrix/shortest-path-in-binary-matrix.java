class Solution {
    public int shortestPathBinaryMatrix(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        if(arr[0][0]==1 || arr[m-1][n-1]==1) return -1;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        boolean visited[][] = new boolean[m][n];
        visited[0][0]=true;
        int c=1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int p[]=q.remove();
                int i=p[0];
                int j=p[1];
                if(i==m-1 && j==n-1) return c;
                for(int d[]:dir){
                    int ni=i+d[0];
                    int nj=j+d[1];
                    if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && arr[ni][nj]==0){
                        q.add(new int[]{ni,nj});
                        visited[ni][nj]=true;
                    }
                }
            }
            c++;
        }
        return -1;
    }
}