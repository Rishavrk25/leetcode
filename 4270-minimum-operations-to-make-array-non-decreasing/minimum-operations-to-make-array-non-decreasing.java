class Solution {
    public long minOperations(int[] arr) {
        int n=arr.length;
        long ans = 0;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                ans+=arr[i-1]-arr[i];
            }
        }
        return ans;
    }
}