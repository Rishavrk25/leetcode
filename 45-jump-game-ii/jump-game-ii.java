class Solution {
    int helper(int arr[],int i,int n,int dp[]){
        if(i>=n-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int c=n-1;
        for(int j=1;j<=arr[i];j++){
            c=Math.min(c,1 + helper(arr,i+j,n,dp));
        }
        return dp[i]=c;
    }
    public int jump(int[] arr) {
        int n=arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,n,dp);
    }
}