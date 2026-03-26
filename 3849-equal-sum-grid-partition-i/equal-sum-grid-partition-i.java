class Solution {
    public boolean canPartitionGrid(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        long total = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=arr[i][j];
            }
        }
        long rowsum[] = new long[m];
        for(int i=0;i<m;i++){
            int s=0;
            for(int j=0;j<n;j++){
                s+=arr[i][j];
            }
            rowsum[i] = s;
        }
        long colsum[] = new long[n];
        for(int j=0;j<n;j++){
            int s=0;
            for(int i=0;i<m;i++){
                s+=arr[i][j];
            }
            colsum[j] = s;
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