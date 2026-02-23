class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int dp[] = new int[n]; // i pe end hone wale lis ka length store karo
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){ 
            for(int j=0;j<i;j++){
               if(arr[j]<arr[i]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}