class Solution {
    int helper(int arr[][],int i,int j,int dp[][]){
        if(i==0 && j==0) return arr[0][0];
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        int dir[][] = {{0,-1},{-1,0}};
        for(int d[] : dir){
            int i_ = i+d[0];
            int j_ = j+d[1];
            if(i_>=0 && j_>=0){
                int sum = arr[i][j] + helper(arr,i_,j_,dp);
                min = Math.min(min,sum);
            }
        }
        return dp[i][j]=min;
    }
    public int minPathSum(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int dp[][] = new int[m][n];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(arr,m-1,n-1,dp);
    }
}