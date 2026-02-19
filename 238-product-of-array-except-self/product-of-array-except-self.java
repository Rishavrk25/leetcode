class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        pre[0] = arr[0];
        suf[n-1]=arr[n-1];
        for(int i=1;i<n-1;i++){
            pre[i] = arr[i] * pre[i-1];
            suf[n-i-1] = arr[n-i-1] * suf[n-i];
        }
        for(int i=0;i<n;i++){
            int l = (i==0) ? 1 : pre[i-1];
            int r = (i==n-1) ? 1 : suf[i+1];
            arr[i] = l*r;
        }
        return arr;
    }
}