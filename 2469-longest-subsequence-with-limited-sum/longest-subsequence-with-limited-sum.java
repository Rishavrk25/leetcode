class Solution {
    public int[] answerQueries(int[] arr, int[] queries) {
        Arrays.sort(arr);
        int n=arr.length;
        int m=queries.length;
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<m;i++){
            int j=0;
            while(j<n && queries[i]>=arr[j]) j++;
            queries[i]=j;
        }
        return queries;
    }
}