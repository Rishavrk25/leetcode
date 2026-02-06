class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int s, int e) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double wt = succProb[i];
            adj.get(u).add(new double[]{v,wt});
            adj.get(v).add(new double[]{u,wt});
        }
        double dist[] =  new double[n];
        Arrays.fill(dist,0);
        dist[s]=1;
        PriorityQueue<double[]> q = new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        q.add(new double[]{s,1});
        while(!q.isEmpty()){
            double p[]=q.remove();
            int u=(int)p[0];
            double prob = p[1];
            if(prob < dist[u]) continue;
            for(double nei[]:adj.get(u)){
                int v=(int)nei[0];
                double wt = nei[1];
                if(prob * wt > dist[v]){
                    dist[v]=prob*wt;
                    q.add(new double[]{v,dist[v]});
                }
            }
        }
        return dist[e];
    }
}