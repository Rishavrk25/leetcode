class Solution {
    int mod = -(int)1e9;
    int helper(List<Integer> arr,int i,int target,int dp[][]){
        if(i==arr.size()){
            if(target==0) return 0;
            else return mod;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int take = mod;
        if(target-arr.get(i)>=0) take = 1+helper(arr,i+1,target-arr.get(i),dp);
        int skip = helper(arr,i+1,target,dp);
        return dp[i][target] = Math.max(take,skip);
    }
    public int lengthOfLongestSubsequence(List<Integer> arr, int target) {
        int n=arr.size();
        int dp[][] = new int[n][target+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        int ans = helper(arr,0,target,dp);
        if(ans<0) return -1;
        return ans;
    }
}