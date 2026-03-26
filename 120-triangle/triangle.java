class Solution {
    int mod = -((int)10e4-1);
    int helper(List<List<Integer>> arr,int i,int j,int dp[][]){
        int n = arr.size();
        if(dp[i][j]!=mod) return dp[i][j];
        if(i==n-1) return arr.get(i).get(j);
        int a = arr.get(i).get(j) + helper(arr,i+1,j,dp);
        int b = arr.get(i).get(j) + helper(arr,i+1,j+1,dp);
        return dp[i][j]=Math.min(a,b);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int row[]:dp) Arrays.fill(row,mod);
        return helper(triangle,0,0,dp);
    }
}