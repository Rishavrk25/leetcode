class Solution {
    public int minimumDistance(int[] arr) {
        int n=arr.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]==arr[j] && arr[j]==arr[k]){
                        int d = (j-i) + (k-j) + (k-i);
                        ans = Math.min(ans,d);
                    }
                }
            }
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}