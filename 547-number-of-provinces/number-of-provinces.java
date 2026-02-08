class Solution {
    int parent[];
    int size[];
    int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(size[a] > size[b]){
                parent[b]=a;
                size[a]+=size[b];
            }
            else{
                parent[a]=b;
                size[b]+=size[a];
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // edge is from i+1 to j+1
                if(i!=j && adj[i][j]==1) union(i+1,j+1);
            }
        }
        int c=0;
        for(int i=1;i<n+1;i++){
            if(find(i)==i) c++;
        }
        return c;
    }
}