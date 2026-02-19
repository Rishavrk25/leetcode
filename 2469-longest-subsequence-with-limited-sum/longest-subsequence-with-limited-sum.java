class Solution {
    int bs(int pre[],int t){
        int l=0;
        int h=pre.length;
        while(l<h){
            int m = l + (h-l)/2;
            if(pre[m]<=t) l=m+1;
            else h=m;
        }
        return h;
    }
    public int[] answerQueries(int[] arr, int[] queries) {
        Arrays.sort(arr);
        int n=arr.length;
        int m=queries.length;
        // convert arr to pre
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<m;i++){
            queries[i]=bs(arr,queries[i]);
        }
        return queries;
    }
}