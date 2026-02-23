class Solution {
    int helper(int arr[],int i,int prev,int dp[][]){
        if(i>=arr.length) return 0;
        if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];
        int skip = helper(arr,i+1,prev,dp);
        int take=0;
        if(prev==-1 || arr[i] > arr[prev]) take=1+helper(arr,i+1,i,dp);
        int ans = Math.max(skip,take);
        if(prev!=-1) dp[i][prev]=ans;
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][] = new int[n][n];
        for(int a[] : dp) Arrays.fill(a,-1);
        return helper(nums,0,-1,dp);
    }
}