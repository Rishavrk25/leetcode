class Solution {
    boolean helper(int arr[],int i,int target,int dp[][]){
        if(target==0) return true;
        if(i==0) return arr[i]==target;
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean take = false;
        if(target-arr[i]>=0) take = helper(arr,i-1,target-arr[i],dp);
        boolean skip = helper(arr,i-1,target,dp);
        boolean ans = take || skip;
        dp[i][target]=ans?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int ele:nums) total+=ele;
        if(total%2!=0) return false;
        int target = total/2;
        int n=nums.length;
        int dp[][] = new int[n][target+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(nums,n-1,target,dp);
        // dp[0][0]=1;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<target;j++){
        //         if(i==0 && j==0) continue;
        //         int take = 0;
        //         if(j-nums[i]>=0) take = dp[i-1][j-nums[i]];
        //         int skip = dp[i-1][j];
        //         boolean ans = (take==1) || (skip==1);
        //         dp[i][j] = ans?1:0;
        //     }
        // }
        // return dp[n-1][target]==1;

    }
}