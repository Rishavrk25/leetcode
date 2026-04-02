class Solution {
    int helper(int arr[][],int m,int n,int i,int j,int neutralize,int dp[][][]){
        if(i==m-1 && j==n-1){
            if(arr[i][j]<0 && neutralize>0) return 0;
            else return arr[i][j];
        }
        if(dp[i][j][neutralize]!=Integer.MIN_VALUE) return dp[i][j][neutralize];
        int dir[][] = {{0,1},{1,0}};
        int max = -(int)1e9;
        for(int d[]:dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni<0 || nj<0 || ni>=m || nj>=n) continue;
            int cost = 0;
            int temp = helper(arr,m,n,ni,nj,neutralize,dp);
            if(arr[i][j]>=0){
                cost = arr[i][j] + temp;
            }
            else{
                int a=-(int)1e9;
                if(neutralize>0) a = helper(arr,m,n,ni,nj,neutralize-1,dp);
                int b = arr[i][j] + temp;
                cost = Math.max(a,b);
            }
            max = Math.max(max,cost);
        }
        return dp[i][j][neutralize]=max;
    }
    public int maximumAmount(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int dp[][][] = new int[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        return helper(arr,m,n,0,0,2,dp);
    }
}