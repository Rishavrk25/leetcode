class Solution {
    public int minimumEffortPath(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,0}); // i,j,wt
        int dist[][] = new int[n][m];
        for(int a[]:dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0]=0;
        int direction[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int t[] = pq.remove();
            int i=t[0];
            int j=t[1];
            for(int dir[] : direction){
                int i_ = i + dir[0];
                int j_ = j + dir[1];
                if(i_<0 || j_<0 || i_>=n || j_>=m) continue;
                int absDiff = Math.abs(arr[i_][j_]-arr[i][j]);
                int maxAbsDiff = Math.max(absDiff,dist[i][j]);
                if(maxAbsDiff < dist[i_][j_]){
                    dist[i_][j_] = maxAbsDiff;
                    pq.add(new int[]{i_,j_,maxAbsDiff});
                }
            }
        }
        return dist[n-1][m-1];
    }
}