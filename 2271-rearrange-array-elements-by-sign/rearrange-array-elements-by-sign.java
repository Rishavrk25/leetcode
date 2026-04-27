class Solution {
    public int[] rearrangeArray(int[] arr) {
        int n=arr.length;
        int ans[] = new int[n];
        int evenIdx = 0;
        int oddIdx = 1;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                ans[evenIdx]=arr[i];
                evenIdx+=2;
            }
            else{
                ans[oddIdx]=arr[i];
                oddIdx+=2;
            }
        }
        return ans;
    }
}