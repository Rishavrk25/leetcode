class Solution {
    int helper(int arr[],int i,int dp[]){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int skip = helper(arr,i+1,dp);
        int take = arr[i]+helper(arr,i+2,dp);
        return dp[i]=Math.max(skip,take);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}