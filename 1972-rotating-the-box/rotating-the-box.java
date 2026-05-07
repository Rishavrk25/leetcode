class Solution {
    void reverseRow(char arr[][],int r){
        int m=arr.length;
        int n=arr[0].length;
        int i=0;
        int j=n-1;
        while(i<j){
            char temp = arr[r][i];
            arr[r][i]=arr[r][j];
            arr[r][j]=temp;
            i++;
            j--;
        }

    }
    char[][] rotate(char arr[][]){
        int m=arr.length;
        int n=arr[0].length;
        char res[][] = new char[n][m];
        // transpose
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j] = arr[j][i];
            }
        }
        // reverseRow
        for(int i=0;i<n;i++){
            reverseRow(res,i);
        }
        return res;
    }
    public char[][] rotateTheBox(char[][] arr) {
        char res[][] = rotate(arr);
        int m=res.length;
        int n=res[0].length;
        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                if(res[i][j]!='.') continue;
                for(int k=i-1;k>=0;k--){
                    if(res[k][j]=='*') break;
                    if(res[k][j]=='#'){
                        res[k][j]='.';
                        res[i][j]='#';
                        break;
                    }
                }
            }
        }
        return res;
    }
}