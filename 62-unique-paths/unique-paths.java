class Solution {
    // m -> rows
    // n -> cols
    int helper(int i,int j,int m,int n,int dp[][]){
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int dir[][] = {{0,1},{1,0}};
        int ans=0;
        for(int d[] : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni<m && nj<n && ni>=0 && nj>=0){
                ans+=helper(ni,nj,m,n,dp);
            }
        }
        return dp[i][j]=ans;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int row[] : dp) Arrays.fill(row,-1);
        return helper(0,0,m,n,dp);
    }
}