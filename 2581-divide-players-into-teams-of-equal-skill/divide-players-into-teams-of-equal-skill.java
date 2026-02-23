class Solution {
    public long dividePlayers(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        long t = arr[i]+arr[j];
        long ans=0;
        while(i<j){
            if(arr[i]+arr[j]==t){
                ans+= arr[i]*arr[j];
            }
            else return -1;
            i++;
            j--;
        }
        return ans;
    }
}