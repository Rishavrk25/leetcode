class Solution {
    // int helper(int arr[],int n,int dp[]){
    //     if(n==0) return arr[0];
    //     if(n==1) return Math.max(arr[0],arr[1]);
    //     if(dp[n]!=-1) return dp[n];
    //     int skip = helper(arr,n-1,dp);
    //     int take = arr[n]+helper(arr,n-2,dp);
    //     return dp[n]=Math.max(skip,take);
    // }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return helper(nums,n-1,dp);
        dp[0] = nums[0];
        if(n==1) return nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int skip = dp[i-1];
            int take = nums[i] + dp[i-2];
            dp[i] = Math.max(skip,take);
        }
        return dp[n-1];
    }
}