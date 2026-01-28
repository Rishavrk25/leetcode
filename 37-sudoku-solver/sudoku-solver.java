class Solution {
    boolean isSafe(char arr[][],int row,int col,char val){
        for(int i=0;i<9;i++){
            if(arr[row][i]==val) return false;
            if(arr[i][col]==val) return false;
            if(arr[3*(row/3) + i/3][3*(col/3)+i%3]==val) return false;
        }
        return true;
    }
    boolean helper(char arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(arr,i,j,k)){
                            arr[i][j]=k;
                            if(helper(arr)) return true;
                             arr[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
        
    }
    public void solveSudoku(char[][] arr) {
        helper(arr);
    }
}