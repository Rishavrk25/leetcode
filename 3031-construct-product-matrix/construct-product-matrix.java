class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long arr[] = new long[m*n];
        long pre[] = new long[m*n];
        long suf[] = new long[m*n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k]=grid[i][j];
                pre[k]=grid[i][j];
                suf[k]=grid[i][j];
                k++;
            }
        }
        for(int i=1;i<m*n;i++){
            pre[i]= (pre[i]*pre[i-1]) % 12345;
        }
        for(int i=m*n-2;i>=0;i--){
            suf[i]= (suf[i]*suf[i+1]) % 12345;
        }
        for(int i=0;i<m*n;i++){
            long a=1;
            long b=1;
            if(i-1>=0) a=pre[i-1];
            if(i+1<m*n) b=suf[i+1];
            arr[i] =(a * b) % 12345;
        }
        k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = (int)arr[k++];
            }
        }
        return grid;
    }
}