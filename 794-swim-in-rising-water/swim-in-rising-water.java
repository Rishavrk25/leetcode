class Solution {
    public int swimInWater(int[][] arr) {
        int n=arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        q.add(new int[]{0,0,arr[0][0]}); // i,j,time
        int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
        int dist[][] = new int[n][n];
        for(int a[]:dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0]=arr[0][0];
        while(!q.isEmpty()){
            int t[] = q.remove();
            int i=t[0];
            int j=t[1];
            int time=t[2];

            for(int dir[]:directions){
                int i_ = i+dir[0];
                int j_ = j+dir[1];
                if(i_<0 || i_>=n || j_<0 || j_>=n) continue;
                if(Math.max(time,arr[i_][j_]) < dist[i_][j_]){
                    dist[i_][j_]=Math.max(time,arr[i_][j_]);
                    q.add(new int[]{i_,j_,Math.max(time,arr[i_][j_])});
                }
            }
        }
        return dist[n-1][n-1];
    }
}