class Solution {
    boolean helper(int arr[],int i,int sum,int total,int dp[][]){
        if(i==0) return sum==total-sum;
        if(dp[i][sum]!=-1) return dp[i][sum]==1;
        boolean take = false;
        if(sum+arr[i]<total) take=helper(arr,i-1,sum+arr[i],total,dp);
        boolean skip = helper(arr,i-1,sum,total,dp);
        boolean ans = take || skip;
        dp[i][sum]=ans?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int ele:nums) total+=ele;
        if(total%2!=0) return false;
        int n=nums.length;
        int dp[][] = new int[n][total];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(nums,n-1,0,total,dp);
        // for(int j=0;j<total;j++){
        //     if(j == total-j) dp[0][j]=1;
        // }
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<total;j++){
        //         int take = 0;
        //         if(j+nums[i]<total) take = dp[i-1][j+nums[i]];
        //         int skip = dp[i-1][j];
        //         boolean ans = (take==1) || (skip==1);
        //         dp[i][j] = ans?1:0;
        //     }
        // }
        // return dp[n-1][total-1]==1;

    }
}