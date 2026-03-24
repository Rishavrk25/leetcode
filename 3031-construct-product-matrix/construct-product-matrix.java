class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long pre[][] = new long[m][n];
        long suf[][] = new long[m][n];
        long p = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pre[i][j] = p;
                p =(p * grid[i][j]) % 12345;
            }
        }
        long s = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                suf[i][j] = s;
                s = (s * grid[i][j]) % 12345;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = (int)(pre[i][j]*suf[i][j]) % 12345;
            }
        }
        return grid;
    }
}