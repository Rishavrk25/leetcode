class Solution {
    void reverseRow(int arr[][],int r){
        int m=arr.length;
        int n=arr[0].length;
        int i=0;
        int j=n-1;
        while(i<j){
            int t = arr[r][i];
            arr[r][i]=arr[r][j];
            arr[r][j]=t;
            i++;
            j--;
        }
    }
    public void rotate(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    int t=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=t;
                }
            }
        }
        for(int i=0;i<m;i++){
            reverseRow(arr,i);
        }
    }
}