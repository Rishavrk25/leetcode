class Solution {
    boolean helper(int arr[],int i,int dp[]){
        if(i>=arr.length) return false;
        if(i==arr.length-1) return true;
        if(dp[i]!=-1) return dp[i]==1;
        int ele = arr[i];
        boolean ans=false;
        for(int j=1;j<=ele;j++){
            if(helper(arr,i+j,dp)){
                ans=true;
                break;
            }
        }
        dp[i] = ans ? 1 : 0;
        return ans;
    }
    public boolean canJump(int[] arr) {
        int n=arr.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,dp);
    }
}