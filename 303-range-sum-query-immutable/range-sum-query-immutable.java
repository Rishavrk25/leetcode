class NumArray {
    int arr[];
    int pre[];
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = nums[i];
        pre = new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i] = nums[i] + pre[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return pre[right] - pre[left] + arr[left]; 

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */