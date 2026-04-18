class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            int max = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
            ans = Math.max(ans,dp[i]);
        }
        for(int ele:dp) System.out.print(ele+" ");
        return ans;
    }
}