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
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        int stops=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(stops>k) break;
            for(int i=0;i<size;i++){
                int p[]=q.remove();
                int u=p[0];
                for(int nei[]:adj.get(u)){
                    int v=nei[0];
                    int wt=nei[1];
                    if(p[1]+wt < dist[v]){
                        dist[v]=p[1]+wt;
                        q.add(new int[]{v,dist[v]});
                    }
                }
            }
            stops++;
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        else return dist[dst];
    }
}