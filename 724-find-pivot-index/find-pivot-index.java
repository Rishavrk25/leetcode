class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        pre[0]=nums[0];
        suf[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pre[i] = nums[i] + pre[i-1];
            suf[n-i-1] = nums[n-i-1] + suf[n-i]; 
        }
        for(int i=0;i<n;i++){
            int leftSum = (i==0) ? 0 : pre[i-1];
            int rightSum = (i==n-1) ? 0 : suf[i+1];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}