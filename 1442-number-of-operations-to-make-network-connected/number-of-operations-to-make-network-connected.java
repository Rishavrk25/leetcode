class Solution {
    int parent[];
    int size[];
    int ans;
    int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    void union(int a, int b){
        int leaderA=find(a);
        int leaderB=find(b);
        if(leaderA==leaderB) ans++;
        else{
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
        ans=0;
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            union(u,v);
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) components++;
        }
        return components-1;
    }
}