class Solution {
    int parent[];
    int size[];
    int ans[];
    int find(int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]); 
    }
    void union(int a,int b){
        int leaderA=find(a);
        int leaderB=find(b);
        if(leaderA==leaderB){
            ans=new int[]{a,b};
            return;
        }
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
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            // edge is from u to v
            union(u,v);
        }
        return ans;
    }
}