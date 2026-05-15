class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int l=0;
        int h=n-1;
        while(l<h){
            int m=(l+h)/2;
            if(arr[m] > arr[h]) l=m+1;
            else h=m;
        }
        return arr[l];
    }
}