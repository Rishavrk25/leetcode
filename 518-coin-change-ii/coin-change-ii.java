class Solution {
    int helper(int coins[],int amount,int i,int dp[][]){
        if(i==0){
            if(amount%coins[i]==0) return 1;
            else return 0;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        if(amount==0) return 1;
        int take = 0;
        if(amount-coins[i]>=0) take = helper(coins,amount-coins[i],i,dp);
        int skip = helper(coins,amount,i-1,dp);
        return dp[i][amount] = skip + take;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(coins,amount,n-1,dp);
    }
}