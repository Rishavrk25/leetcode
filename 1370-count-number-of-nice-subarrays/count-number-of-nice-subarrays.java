class Solution {
    int atMostk(int arr[],int k){
        int n=arr.length;
        int i=0;
        int j=0;
        int odd=0;
        int c=0;
        while(j<n){
            if(arr[j]%2!=0) odd++;
            while(odd > k){
                if(arr[i]%2!=0) odd--;
                i++;
            }
            c+=(j-i+1);
            j++;
        }
        return c;
    }
    public int numberOfSubarrays(int[] arr, int k) {
        return atMostk(arr,k) - atMostk(arr,k-1);
    }
}