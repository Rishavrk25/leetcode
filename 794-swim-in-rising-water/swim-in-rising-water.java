class Solution {
    boolean check(int arr[][],boolean visited[][],int i,int j,int time){
        int n=arr.length;
        if(i==n-1 && j==n-1) return true;
        visited[i][j]=true;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        for(int d[]:dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0 || ni>=n || nj<0 || nj>=n || visited[ni][nj] || arr[ni][nj]>time) continue;
            if(check(arr,visited,ni,nj,time)) return true;
        }
        return false;
    }
    public int swimInWater(int[][] arr) {
        int n=arr.length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,arr[i][j]);
            }
        }
        int l=0;
        int h=max;
        while(l<h){
            boolean visited[][] = new boolean[n][n];
            int m=l+(h-l)/2;
            if(arr[0][0]<=m && check(arr,visited,0,0,m)) h=m;
            else l=m+1;
        }
        return h;
    }
}