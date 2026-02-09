class Solution {
    // void dfs(List<List<Integer>> adj , boolean visited[],int i){
    //     visited[i]=true;
    //     for(int nei:adj.get(i)){
    //         if(!visited[nei]) dfs(adj,visited,nei);
    //     }
    // }   
    // public int makeConnected(int n, int[][] edges) {
    //     if(edges.length<n-1) return -1;
    //     List<List<Integer>> adj = new ArrayList<>();
    //     for(int i=0;i<n;i++) adj.add(new ArrayList<>());
    //     for(int a[]:edges){
    //         int u=a[0];
    //         int v=a[1];
    //         adj.get(u).add(v);
    //         adj.get(v).add(u);
    //     }
    //     boolean visited[] = new boolean[n];
    //     int c=0;
    //     for(int i=0;i<n;i++){
    //         if(!visited[i]){
    //             dfs(adj,visited,i);
    //             c++;
    //         }
    //     }
    //     return c-1;
    // }
    int parent[];
    int size[];
    int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    void union(int a, int b){
        int leaderA=find(a);
        int leaderB=find(b);
        if(leaderA!=leaderB){
            if(size[leaderA]>size[leaderB]){
                parent[leaderB]=leaderA;
                size[leaderA]+=size[leaderB];
            }
            else{
                parent[leaderA]=leaderB;
                size[leaderB]+=size[leaderA];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int extraEdges=0;
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(find(u)==find(v)) extraEdges++;
            else union(u,v);
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) components++;
        }
        int ans=components-1;
        if(ans<=extraEdges) return ans;
        else return -1;
    }
}