class Solution {
    int helper(int arr[],int i,int t,int dp[][]){
        // if(i==arr.length){
        //     if(t==0) return 0;
        //     else return (int)1e5;
        // }
        if(t==0) return 0;
        if(i==arr.length) return (int)1e5;
        if(dp[i][t]!=-1) return dp[i][t];
        int take = (int)1e5;
        if(t-arr[i]>=0) take = 1 + helper(arr,i,t-arr[i],dp);
        int skip = helper(arr,i+1,t,dp);
        return dp[i][t]=Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        int ans = helper(coins,0,amount,dp);
        if(ans==(int)1e5) return -1;
        else return ans;
    }
}