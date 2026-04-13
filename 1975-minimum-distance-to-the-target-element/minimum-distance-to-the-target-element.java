class Solution {
    public int getMinDistance(int[] arr, int t, int s) {
        int n=arr.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]==t) min = Math.min(min,Math.abs(i-s));
        }
        return min;
    }
}