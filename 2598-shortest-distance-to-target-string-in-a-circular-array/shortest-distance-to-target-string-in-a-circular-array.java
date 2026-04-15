class Solution {
    public int closestTarget(String[] arr, String t, int s) {
        int n=arr.length;
        int ans = Integer.MAX_VALUE;
        int i=s;
        int j=s;
        int k=0;
        while(k<n){
            if(arr[i].equals(t) || arr[j].equals(t)){
                ans = k;
                break;
            }
            i = (i+1)%n;
            j = (j-1+n)%n;
            k++;
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
        

    }
}