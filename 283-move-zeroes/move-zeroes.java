class Solution {
    public void moveZeroes(int[] arr) {
        int i=0;
        int n=arr.length;
        while(i<n && arr[i]!=0) i++;
        int j=i+1;
        while(j<n){
            if(arr[j]!=0){
                arr[i]=arr[j];
                arr[j]=0;
                i++;
                j++;
            }
            else j++;
        }
    }
}