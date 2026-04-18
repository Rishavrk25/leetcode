class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int dp1[] = new int[n];
        for(int i=n-1;i>=0;i--){
            dp1[i]=1;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    dp1[i] = Math.max(dp1[i],dp1[j]+1);
                }
            }
        }
        for(int ele:dp1) System.out.print(ele+" ");
        int maxLen = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==1 || dp1[i]==1) continue;
            int len = dp[i] + dp1[i] - 1;
            maxLen = Math.max(maxLen,len);
        }
        return n-maxLen;
    }
}