class Solution {
    // Tarjan's Algorithm
    int timer=0;
    void dfs(int node,int parent,boolean vis[],List<List<Integer>> adj,int tin[],int low[],List<List<Integer>> bridges){
        vis[node]=true;
        tin[node]=low[node]=timer++;
        for(int nei:adj.get(node)){
            if(nei==parent) continue;
            if(!vis[nei]){
                dfs(nei,node,vis,adj,tin,low,bridges);
                low[node] = Math.min(low[node], low[nei]);
                if (low[nei] > tin[node]) {
                    bridges.add(Arrays.asList(nei, node));
                }
            }
            else{
                low[node] = Math.min(low[node], low[nei]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> list :connections){
            int u=list.get(0);
            int v=list.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int tin[] = new int[n]; // time of insertion (Discovery time)
        int low[] = new int[n]; // From this node, how far back in DFS tree can I go?
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
        return bridges;
    }
}