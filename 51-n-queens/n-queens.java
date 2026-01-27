class Solution {
    boolean canPlaceQueen(char board[][],int row,int col,int n){
        // left
        int i=row;
        int j=col-1;
        while(j>=0){
            if(board[i][j]=='Q') return false;
            j--;
        }
        // top-left
        i=row-1;
        j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        // bottom-left
        i=row+1;
        j=col-1;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
        return true;
    }
    void helper(char board[][],int n,int col,List<List<String>> ans){
        if(col==n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }
        for(int row=0;row<n;row++){
            if(canPlaceQueen(board,row,col,n)){
                board[row][col]='Q';
                helper(board,n,col+1,ans);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i],'.');
        helper(board,n,0,ans);
        return ans;
    }
}