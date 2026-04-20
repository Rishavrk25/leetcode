class Solution {
    public int maxDistance(int[] arr) {
        int n=arr.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && arr[i]!=arr[j]){
                    ans = Math.max(ans,Math.abs(i-j));
                }
            }
        }
        return ans;
    }
}