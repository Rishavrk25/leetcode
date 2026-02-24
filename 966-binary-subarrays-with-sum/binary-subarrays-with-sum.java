class Solution {
    int atMostK(int arr[],int k){
        if(k<0) return 0;
        int n=arr.length;
        int i=0;
        int j=0;
        int c=0;
        int sum=0;
        while(j<n){
            sum+=arr[j];
            while(sum>k){
                sum-=arr[i];
                i++;
            }
            c+=(j-i+1);
            j++;
        }
        return c;
    }
    public int numSubarraysWithSum(int[] arr, int k) {
        return atMostK(arr,k)-atMostK(arr,k-1);
    }
}