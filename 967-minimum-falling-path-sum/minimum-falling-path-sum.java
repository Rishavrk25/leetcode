class Solution {
    int helper(int arr[][],int i,int j,int m,int n,int dp[][]){
        if(i<0 || j<0 || i>=m || j>=n) return (int)1e5;
        if(dp[i][j]!=-101) return dp[i][j];
        if(i==m-1) return arr[i][j];
        int dir[][] = {{1,-1},{1,0},{1,1}};
        int min = Integer.MAX_VALUE;
        for(int d[] : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            int sum = arr[i][j]+helper(arr,ni,nj,m,n,dp);
            min = Math.min(min,sum);
        }
        return dp[i][j] = min;
    }
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int ans = Integer.MAX_VALUE;
        int dp[][] = new int[m][n];
        for(int row[]:dp) Arrays.fill(row,-101);
        for(int j=0;j<n;j++){
            ans = Math.min(ans,helper(arr,0,j,m,n,dp));
        }
        return ans;
    }
}