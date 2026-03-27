class Solution {
    public boolean areSimilar(int[][] arr, int k) {
        int m=arr.length;
        int n=arr[0].length;
        int original[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                original[i][j]=arr[i][j];
            }
        }
        while(k-->0){
            for(int i=0;i<m;i++){
                if(i%2==0){
                    // even -> left shift
                    int temp = arr[i][0];
                    for(int j=0;j<n-1;j++){
                        arr[i][j] = arr[i][j+1];
                    }
                    arr[i][n-1]=temp;
                }
                else{
                    // odd -> right shift
                    int temp = arr[i][n-1];
                    for(int j=n-1;j>0;j--){
                        arr[i][j] = arr[i][j-1];
                    }
                    arr[i][0] = temp;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(original[i][j]!=arr[i][j]) return false;
            }
        }
        return true;
    }
}