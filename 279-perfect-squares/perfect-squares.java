class Solution {
    int helper(int n,int i,int dp[][]){
        if(n==0) return 0;
        if(n<i*i) return (int)1e9;
        if(dp[n][i]!=-1) return dp[n][i];
        int skip = helper(n,i+1,dp);
        int take = 1+helper(n-i*i,i,dp);
        return dp[n][i]=Math.min(skip,take);
    }
    public int numSquares(int n) {
        if(n==1) return 1;
        int dp[][] = new int[n+1][(int)Math.sqrt(n)+1];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return helper(n,1,dp);
    }
}