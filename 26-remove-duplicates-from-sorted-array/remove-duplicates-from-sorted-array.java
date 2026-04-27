class Solution {
    public int removeDuplicates(int[] arr) {
        int i=0;
        int j=0;
        int n=arr.length;
        while(j<n){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
            else j++;
        }
        return i+1;
    }
}