class Solution {
    // m -> rows
    // n -> cols
    // int helper(int m,int n,int dp[][]){
    //     if(m==0 && n==0) return 1;
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     int dir[][] = {{0,-1},{-1,0}};
    //     int ans=0;
    //     for(int d[] : dir){
    //         int m_ = m + d[0];
    //         int n_ = n + d[1];
    //         if(m_>=0 && n_>=0){
    //             ans+=helper(m_,n_,dp);
    //         }
    //     }
    //     return dp[m][n]=ans;
    // }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        // for(int row[] : dp) Arrays.fill(row,-1);
        // return helper(m-1,n-1,dp);
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int ans = 0;
                int dir[][] = {{0,-1},{-1,0}};
                for(int d[]:dir){
                    int i_ = i+d[0];
                    int j_ = j+d[1];
                    if(i_>=0 && j_>=0){
                        ans += dp[i_][j_];
                    }
                }
                dp[i][j] = ans;
            }
        }
        return dp[m-1][n-1];
    }
}