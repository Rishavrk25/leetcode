class Solution {
    int helper(int arr[],int i,int dp[]){
        int n=arr.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int a = arr[i] + helper(arr,i+1,dp);
        int b = arr[i] + helper(arr,i+2,dp);
        return dp[i] = Math.min(a,b);
    }
    public int minCostClimbingStairs(int[] arr) {
        int n=arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(arr,0,dp),helper(arr,1,dp));
    }
}