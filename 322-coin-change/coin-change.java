class Solution {
    int helper(int arr[],int amount,int i,int dp[][]){
        if(i==0){
            if(amount%arr[0]==0) return amount/arr[0];
            else return (int)1e9;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take = (int)1e9;
        if(amount-arr[i]>=0) take = helper(arr,amount-arr[i],i,dp);
        int skip = helper(arr,amount,i-1,dp);
        return dp[i][amount] = take+skip;
    }
    public int coinChange(int[] arr, int amount) {
        int n=arr.length;
        int dp[][] = new int[n][amount+1];
        // for(int row[]:dp) Arrays.fill(row,-1);
        // int ans=helper(arr,amount,arr.length-1,dp);
        // if(ans==(int)1e9) return -1;
        // return ans;
        for(int j=0;j<amount+1;j++){
            if(j%arr[0]==0) dp[0][j]=j/arr[0];
            else dp[0][j]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<amount+1;j++){
                int take = (int)1e9;
                if(j-arr[i]>=0) take = 1 + dp[i][j-arr[i]];
                int skip = dp[i-1][j];
                dp[i][j] = Math.min(take,skip);
            }
        }
        int ans = dp[n-1][amount];
        if(ans==(int)1e9) return -1;
        return ans;
    }
}