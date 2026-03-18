class Solution {
    // int helper(int arr[],int i,int n,int dp[]){
    //     if(n==i) return arr[i];
    //     if(n==i+1) return Math.max(arr[i],arr[i+1]);
    //     if(dp[n]!=-1) return dp[n];
    //     int skip = helper(arr,i,n-1,dp);
    //     int take = arr[n]+helper(arr,i,n-2,dp);
    //     return dp[n]=Math.max(skip,take);
    // }
    int helper(int arr[],int s,int n){ // s -> start
        int dp[] = new int[arr.length];
        dp[s]=arr[s];
        if(s==n) return arr[s];
        dp[s+1] = Math.max(arr[s],arr[s+1]);
        for(int i=s+2;i<=n;i++){
            int skip = dp[i-1];
            int take = arr[i] + dp[i-2];
            dp[i] = Math.max(skip,take);
        }
        return dp[n];
    }
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int a = helper(arr,0,n-2);
        int b = helper(arr,1,n-1);
        return Math.max(a,b);
    }
}