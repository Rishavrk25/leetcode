class Solution {
    public int swimInWater(int[][] arr) {
        int n=arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        q.add(new int[]{0,0,arr[0][0]}); // i,j,wt
        int dist[][] = new int[n][n];
        for(int a[] : dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0]=arr[0][0];
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int t[]=q.remove();
            int i=t[0];
            int j=t[1];
            int cost=t[2];
            for(int d[]:dir){
                int ni=i+d[0];
                int nj=j+d[1];
                if(ni<0 || ni>=n || nj<0 || nj>=n) continue;
                int total = Math.max(cost,arr[ni][nj]);
                if(total < dist[ni][nj]){
                    dist[ni][nj]=total;
                    q.add(new int[]{ni,nj,total});
                }
            }
        }
        return dist[n-1][n-1];
    }
}