class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        for(int a[]:times){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            adj.get(u).add(new int[]{v,wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int p[] = pq.remove();
            int u=p[0];
            for(int nei[]:adj.get(u)){
                int v=nei[0];
                int wt=nei[1];
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        int max=0;
        for(int i=1;i<n+1;i++) max=Math.max(max,dist[i]);
        return max==Integer.MAX_VALUE?-1:max;
    }
}