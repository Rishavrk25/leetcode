class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        int pre[] = new int[n];
        pre[0]=nums[0];
        long ans[]=new long[n];
        ans[0] = pre[0] + nums[0];
        for(int i=1;i<n;i++){
            pre[i] = Math.max(nums[i],pre[i-1]);
            ans[i] = pre[i] + nums[i] + ans[i-1];
        }
        return ans;
        
        
    }
}