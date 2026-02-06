class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Build adj list
        int n=points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=0;j<n;j++){
                if(i!=j){
                    int x2=points[j][0];
                    int y2=points[j][1];
                    int u=i;
                    int v=j;
                    int wt = Math.abs(x1-x2) + Math.abs(y1-y2);
                    adj.get(u).add(new int[]{v,wt});
                    adj.get(v).add(new int[]{u,wt});
                }
            }
        }
        // Prims algo
        boolean visited[] = new boolean[n];
        int sum=0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int p[] = q.remove();
            int u=p[0];
            int w=p[1];
            if(visited[u]) continue;
            visited[u]=true;
            sum+=w;
            for(int nei[]:adj.get(u)){
                int v=nei[0];
                int wt=nei[1];
                if(!visited[v]){
                    q.add(new int[]{v,wt});
                }
            }
        }
        return sum;
    }
}