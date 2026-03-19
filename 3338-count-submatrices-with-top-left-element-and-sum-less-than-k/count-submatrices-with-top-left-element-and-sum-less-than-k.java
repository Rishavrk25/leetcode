class Solution {
    public int countSubmatrices(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    if(arr[i][j]<=k) c++;
                    continue;
                }
                if(i==0) arr[i][j] += arr[i][j-1];
                else if(j==0) arr[i][j] += arr[i-1][j];
                else{
                    arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
                }
                if(arr[i][j]<=k) c++;
            }
        }
        return c;
    }
}