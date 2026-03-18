class Solution {
    int helper(int arr[],int i,int n,int dp[]){
        if(n==i) return arr[i];
        if(n==i+1) return Math.max(arr[i],arr[i+1]);
        if(dp[n]!=-1) return dp[n];
        int skip = helper(arr,i,n-1,dp);
        int take = arr[n]+helper(arr,i,n-2,dp);
        return dp[n]=Math.max(skip,take);
    }
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int a = helper(arr,1,n-1,dp);
        Arrays.fill(dp,-1);
        int b = helper(arr,0,n-2,dp);
        return Math.max(a,b);
    }
}