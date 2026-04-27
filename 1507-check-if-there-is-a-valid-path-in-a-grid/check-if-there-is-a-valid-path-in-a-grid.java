class Solution {
    boolean dfs(int arr[][],int i,int j,boolean vis[][],HashMap<Integer,int[][]> map,int m,int n){
        if(i==m-1 && j==n-1) return true;
        vis[i][j]=true;
        for(int d[] : map.get(arr[i][j])){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni<0 || nj<0 || ni>=m || nj>=n || vis[ni][nj]) continue;
            for(int bd[] : map.get(arr[ni][nj])){
                if(ni + bd[0] == i && nj + bd[1] == j){
                    if(dfs(arr,ni,nj,vis,map,m,n)) return true;
                }
            }
        }
        return false;
        
    }
    public boolean hasValidPath(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        boolean vis[][] = new boolean[m][n];
        HashMap<Integer,int[][]> map = new HashMap<>();
        map.put(1,new int[][]{{0,-1},{0,1}});
        map.put(2,new int[][]{{-1,0},{1,0}});
        map.put(3,new int[][]{{0,-1},{1,0}});
        map.put(4,new int[][]{{0,1},{1,0}});
        map.put(5,new int[][]{{0,-1},{-1,0}});
        map.put(6,new int[][]{{0,1},{-1,0}});
        return dfs(arr,0,0,vis,map,m,n);
        
    }
}