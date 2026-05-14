class Solution {
    public boolean isGood(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int max=arr[n-1];
        if(n!=max+1) return false; 
        if(n==1) return false;
        if(arr[n-1]!=arr[n-2]) return false;
        for(int i=1;i<n-1;i++){
            if(arr[i] != arr[i-1]+1) return false;
        }
        return true;
    }
}