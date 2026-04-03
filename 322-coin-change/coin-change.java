class Solution {
    int helper(int arr[],int amount,int i,int dp[][]){
        if(i==0){
            if(amount%arr[0]==0) return amount/arr[0];
            else return (int)1e9;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take = (int)1e9;
        if(amount-arr[i]>=0) take = 1+helper(arr,amount-arr[i],i,dp);
        int skip = helper(arr,amount,i-1,dp);
        return dp[i][amount] = Math.min(take,skip);
    }
    public int coinChange(int[] arr, int amount) {
        int n=arr.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        int ans=helper(arr,amount,arr.length-1,dp);
        if(ans==(int)1e9) return -1;
        return ans;
    }
}