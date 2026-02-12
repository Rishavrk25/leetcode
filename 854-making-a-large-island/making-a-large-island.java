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
    public int largestIsland(int[][] arr) {
        int n=arr.length;
        parent = new int[n*n];
        size = new int[n*n];
        for(int i=0;i<n*n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    for(int d[]:dir){
                        int ni=i+d[0];
                        int nj=j+d[1];
                        if(ni<0 || ni>=n || nj<0 || nj>=n || arr[ni][nj]!=1) continue;
                        int nodeNo = i*n + j;
                        int adjnodeNo = ni*n + nj;
                        union(nodeNo,adjnodeNo);
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    Set<Integer> set = new HashSet<>();
                    for(int d[]:dir){
                        int ni=i+d[0];
                        int nj=j+d[1];
                        if(ni<0 || ni>=n || nj<0 || nj>=n || arr[ni][nj]!=1) continue;
                        int adjnodeNo = ni*n + nj;
                        set.add(find(adjnodeNo));
                    }
                    int total=1;
                    for(int ele : set){
                        total+=size[ele];
                    }
                    max=Math.max(max,total);
                }
            }
        }
        return max==0 ? n*n : max;
    }
}