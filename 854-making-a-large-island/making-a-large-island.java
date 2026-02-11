class Solution {
    int dfs(int arr[][],int i,int j,int n,int uniqueId){
        arr[i][j]=uniqueId;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        int size=1;
        for(int d[]:dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0 || ni>=n || nj<0 || nj>=n || arr[ni][nj]!=1) continue;
            size += dfs(arr,ni,nj,n,uniqueId);
        }
        return size;
    }
    public int largestIsland(int[][] arr) {
        int n=arr.length;
        // boolean visited[][] = new boolean[n][n];
        Map<Integer,Integer> map = new HashMap<>();
        int uniqueId=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    int size=dfs(arr,i,j,n,uniqueId);
                    map.put(uniqueId,size);
                    uniqueId++;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
                    Set<Integer> set = new HashSet<>();
                    int size=1;
                    for(int d[]:dir){
                        int ni=i+d[0];
                        int nj=j+d[1];
                        if(ni<0 || ni>=n || nj<0 || nj>=n || arr[ni][nj]<=1 || set.contains(arr[ni][nj])) continue;
                        size+=map.get(arr[ni][nj]);
                        set.add(arr[ni][nj]);
                    }
                    arr[i][j]=0;
                    max=Math.max(max,size);
                }
            }
        }
        return max==0?n*n:max;
    }
}