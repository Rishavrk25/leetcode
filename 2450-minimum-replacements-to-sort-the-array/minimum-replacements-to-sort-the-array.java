class Solution {
    public long minimumReplacement(int[] arr) {
        int n=arr.length;
        long op = 0;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]) continue;
            int parts = arr[i]/arr[i+1];
            if(arr[i]%arr[i+1]!=0) parts++;
            op+=parts-1;
            arr[i] = arr[i]/parts;
        }
        return op;
    }
}