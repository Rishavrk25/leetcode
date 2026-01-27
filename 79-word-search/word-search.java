class Solution {
    boolean helper(char arr[][],int i,int j,String word,String s,int k,boolean visited[][],int n,int m){
        if(s.equals(word)) return true;
        if(k>=word.length() || i<0 || j<0 || i>=n || j>=m || visited[i][j] || word.charAt(k)!=arr[i][j] ) return false;
        visited[i][j]=true;
        int direction[][]={{0,-1},{0,1},{1,0},{-1,0}};
        boolean ans = false;
        for(int dir=0;dir<4;dir++){
            int i_=i+direction[dir][0];
            int j_=j+direction[dir][1];
            ans = ans || helper(arr,i_,j_,word,s+arr[i][j],k+1,visited,n,m);
        }
        visited[i][j]=false;

        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][] = new boolean[n][m];
        boolean ans = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    ans = ans || helper(board,i,j,word,"",0,visited,n,m);
                }
            }
        }
        return ans;
    }
}