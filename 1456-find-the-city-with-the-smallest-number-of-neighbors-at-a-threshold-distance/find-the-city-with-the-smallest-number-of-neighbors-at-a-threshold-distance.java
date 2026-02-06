class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adjmat[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) adjmat[i][j]=0;
                else adjmat[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int a[] : edges){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            adjmat[u][v]=wt;
            adjmat[v][u]=wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adjmat[i][k]!=Integer.MAX_VALUE && adjmat[k][j]!=Integer.MAX_VALUE){
                        adjmat[i][j]=Math.min(adjmat[i][j],adjmat[i][k]+adjmat[k][j]);
                    }
                }
            }
        }
        int min=n;
        int city=-1;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(adjmat[i][j]<=distanceThreshold){
                    c++;
                }
            }
            if(c<=min){
                min=c;
                city=i;
            }
            
        }
        return city;
    }
}