class Solution {
    public int longestOnes(int[] arr, int k) {
        int n=arr.length;
        int i=0;
        int j=0;
        int zeros=0;
        int ans=0;
        while(j<n){
            int ch= arr[j];
            if(ch==0) zeros++;
            while(zeros > k){
                if(arr[i]==0) zeros--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}