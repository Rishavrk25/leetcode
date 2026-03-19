class Solution {
    public int numberOfSubmatrices(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int xcount[][] = new int[n][m];
        int ycount[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='X') xcount[i][j]=1;
                if(arr[i][j]=='Y') ycount[i][j]=1;
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;
                if(i==0) xcount[i][j]+=xcount[i][j-1];
                else if(j==0) xcount[i][j]+=xcount[i-1][j];
                else xcount[i][j]+=xcount[i][j-1]+xcount[i-1][j]-xcount[i-1][j-1];
                
                if(i==0) ycount[i][j]+=ycount[i][j-1];
                else if(j==0) ycount[i][j]+=ycount[i-1][j];
                else ycount[i][j]+=ycount[i][j-1]+ycount[i-1][j]-ycount[i-1][j-1];

                if(xcount[i][j]!=0 && xcount[i][j]==ycount[i][j]) c++;
            }
        }
        return c;
    }
}