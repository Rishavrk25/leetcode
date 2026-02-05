class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int a[] : flights){
            int u = a[0];
            int v = a[1];
            int wt = a[2];
            adj.get(u).add(new int[]{v,wt});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        q.add(new int[]{src,0,0}); // v,wt,stops
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            int t[] = q.remove();
            int u = t[0];
            int cost = t[1];
            int stops=t[2];
            if(stops == k+1) continue;
            for(int nei[] : adj.get(u)){
                int v=nei[0];
                int wt=nei[1];
                if(cost + wt < dist[v]){
                    dist[v]=cost+wt;
                    q.add(new int[]{v,dist[v],stops+1});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        else return dist[dst];
    }
}