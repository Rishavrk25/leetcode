class Solution {
    int helper(int arr[][],int i,int j,int dp[][]){
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int dir[][] = {{0,-1},{-1,0}};
        int ans = 0;
        for(int d[]: dir){
            int i_ = i + d[0];
            int j_ = j + d[1];
            if(i_>=0 && j_>=0 && arr[i_][j_]!=1){
                ans += helper(arr,i_,j_,dp);
            }
        }
        return dp[i][j]=ans;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        if(arr[m-1][n-1]==1) return 0;
        int dp[][] = new int[m][n];
        for(int row[] : dp) Arrays.fill(row,-1);
        return helper(arr,m-1,n-1,dp);
    }
}