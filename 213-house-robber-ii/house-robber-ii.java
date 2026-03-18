class Solution {
    // int helper(int arr[],int s,int n,int dp[]){
    //     if(n==s) return arr[s];
    //     if(n==s+1) return Math.max(arr[s],arr[s+1]);
    //     if(dp[n]!=-1) return dp[n];
    //     int skip = helper(arr,s,n-1,dp);
    //     int take = arr[n]+helper(arr,s,n-2,dp);
    //     return dp[n]=Math.max(skip,take);
    // }
    int helper(int arr[],int s,int n){
        int prev2 = arr[s];
        if(s==n) return arr[s];
        int prev = Math.max(arr[s],arr[s+1]);
        for(int i=s+2;i<=n;i++){
            int skip = prev;
            int take = arr[i] + prev2;
            int curr = Math.max(skip,take);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        // int dp[] = new int[n];
        int a=helper(arr,0,n-2);
        int b=helper(arr,1,n-1);
        return Math.max(a,b);
    }
}