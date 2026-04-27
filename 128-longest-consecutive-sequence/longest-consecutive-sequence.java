class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        if(n==0) return 0;
        int max = 1;
        int c=1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]) continue;
            if(arr[i]==arr[i-1]+1){
                c++;
                max = Math.max(max,c);
            }
            else{
                c=1;
            }
        }
        return max;
    }
}