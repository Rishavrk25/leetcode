class Solution {
    public boolean canPartitionGrid(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        long total = 0;
        long rowsum[] = new long[m];
        long colsum[] = new long[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=arr[i][j];
                rowsum[i] +=arr[i][j];
                colsum[j] +=arr[i][j];
            }
        }
        // row partition
        long sum=0;
        for(int i=0;i<m-1;i++){
            sum+=rowsum[i];
            if(sum==total-sum) return true;
        }
        // col partition
        sum=0;
        for(int i=0;i<n-1;i++){
            sum+=colsum[i];
            if(sum==total-sum) return true;
        }
        return false;
    }
}