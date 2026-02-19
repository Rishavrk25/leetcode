class Solution {
    public int pivotIndex(int[] pre) {
        int n=pre.length;
        for(int i=1;i<n;i++){
            pre[i] +=  pre[i-1];
        }
        for(int i=0;i<n;i++){
            int leftSum = (i==0) ? 0 : pre[i-1];
            int rightSum = (i==n-1) ? 0 : pre[n-1] - pre[i];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}