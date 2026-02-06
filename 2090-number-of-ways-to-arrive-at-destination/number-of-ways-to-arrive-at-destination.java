class Solution {
    public int countPaths(int V, int[][] edges) {
        int mod = (int)(1e9+7);
        List<List<long[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            adj.get(u).add(new long[]{v,wt});
            adj.get(v).add(new long[]{u,wt});
        }
        PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        q.add(new long[]{0,0});
        long dist[] = new long[V];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        long ways[] = new long[V];
        ways[0]=1;
        while(!q.isEmpty()){
            long p[] = q.remove();
            int u=(int)p[0];
            long cost=p[1];
            if(cost > dist[u]) continue;
            for(long nei[]:adj.get(u)){
                int v=(int)nei[0];
                long wt=nei[1];
                if(cost + wt < dist[v]){
                    dist[v]=cost+wt;
                    q.add(new long[]{v,dist[v]});
                    ways[v] = ways[u];
                }
                else if(cost+wt==dist[v]) ways[v]=(ways[u]+ways[v])%mod;
            }
        }
        long ans = ways[V-1];
        return (int)ans;
    }
}