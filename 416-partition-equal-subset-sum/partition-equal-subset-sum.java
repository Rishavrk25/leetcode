class Solution {
    boolean helper(int arr[],int i,int sum,int total,int dp[][]){
        if(i==arr.length){
            if(sum==total-sum) return true;
            else return false;
        }
        if(dp[i][sum]!=-1) return dp[i][sum]==1;
        boolean take = helper(arr,i+1,sum+arr[i],total,dp);
        boolean skip = helper(arr,i+1,sum,total,dp);
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
        return helper(nums,0,0,total,dp);
    }
}