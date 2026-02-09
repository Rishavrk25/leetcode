class Solution {
    int parent[];
    int size[];
    int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b]=a;
                size[a]+=size[b];
            }
            else{
                parent[a]=b;
                size[b]+=size[a];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            int r=stones[i][0];
            int c=stones[i][1];
            for(int j=i+1;j<n;j++){
                int nr=stones[j][0];
                int nc=stones[j][1];
                if(r==nr || c==nc){
                    union(i,j);
                }
            }
        }
        int groups=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) groups++;
        }
        return n-groups;
    }
}