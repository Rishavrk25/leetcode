class Solution {
    int mod = -((int)1e4-1);
    int helper(List<List<Integer>> arr,int i,int j,int dp[][]){
        if(i<0 || j<0 || j>i) return -mod;
        if(i==0 && j==0) return arr.get(0).get(0);
        if(dp[i][j]!=mod) return dp[i][j];
        int a = arr.get(i).get(j) + helper(arr,i-1,j,dp);
        int b = arr.get(i).get(j) + helper(arr,i-1,j-1,dp);
        return dp[i][j]=Math.min(a,b);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int ans = Integer.MAX_VALUE;
        int n = arr.size();
        int dp[][] = new int[n][n];
        for(int row[]:dp) Arrays.fill(row,mod);
        List<Integer> list = arr.get(n-1);
        for(int i=0;i<list.size();i++){
            ans = Math.min(ans,helper(arr,n-1,i,dp));
        }
        return ans;
    }
}