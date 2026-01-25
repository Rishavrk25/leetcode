class Solution {
    boolean isValid(int arr[],int mid , int threshold){
        int sum = 0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=(int)Math.ceil((double)arr[i]/mid);
        }
        return sum<=threshold;
    }
    public int smallestDivisor(int[] arr, int threshold) {
        int n=arr.length;
        Arrays.sort(arr);
        int l=1;
        int h=arr[n-1];
        while(l<h){
            int mid = l + (h-l)/2;
            if(isValid(arr,mid,threshold)) h=mid;
            else l=mid+1; 
        }
        return l;
    }

}