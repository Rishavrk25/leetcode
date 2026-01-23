class Solution {
    boolean helper(int arr[],int i,int n,int dp[]){
        if(i==n-1) return true;
        if(dp[i]!=-1) return dp[i]==1;
        boolean flag=false;
        for(int j=1;j<=arr[i];j++){
            flag=flag||helper(arr,i+j,n,dp);
        }
        dp[i]=flag?1:0;
        return flag;
    }
    public boolean canJump(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,n,dp);
        // Brute Force
        // int n=arr.length;
        // if(n==1) return true;
        // boolean iszero=false;
        // for(int i=0;i<n-1;i++) if(arr[i]==0) iszero=true;
        // if(!iszero) return true;
        // for(int i=0;i<n-1;i++){
        //     if(arr[i]==0){
        //         boolean flag=false;
        //         for(int j=i-1;j>=0;j--){
        //             if(j+arr[j]>i){
        //                 flag=true;
        //                 break;
        //             }
        //         }
        //         if(!flag) return false;
        //     }
        // }
        // return true;

        // Greedy
        // int n=arr.length;
        // int maxIdx  = 0;
        // for(int i=0;i<n;i++){
        //     if(maxIdx<i) return false;
        //     maxIdx = Math.max(maxIdx,i+arr[i]);
        // }
        // return true;
        
    }
}