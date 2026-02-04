class Solution {
    public int shortestPathBinaryMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        if(arr[0][0]!=0 || arr[n-1][m-1]!=0) return -1;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0]=true;
        int direction[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int p[] = q.remove();
                if(p[0]==n-1 && p[1]==m-1) return level+1;
                for(int dir[]:direction){
                    int ni = p[0] + dir[0];
                    int nj = p[1] + dir[1];
                    if(ni<0 || nj<0 || ni>=n || nj>=m || visited[ni][nj] || arr[ni][nj]!=0) continue;
                    q.add(new int[]{ni,nj});
                    visited[ni][nj]=true;
                }
            }
            level++;
        }
        return -1;
    }
}