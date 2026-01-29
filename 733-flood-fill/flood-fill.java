class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
        void bfs(int arr[][],int i,int j,int color){
        int n=arr.length;
        int m=arr[0].length;
        Queue<Pair> q = new LinkedList<>();
        int oldcolor = arr[i][j];
        if (oldcolor == color) return;
        arr[i][j]=color;
        q.add(new Pair(i,j));
        int direction[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            Pair p = q.remove();
            for(int dir=0;dir<4;dir++){
                int i_ = p.i+direction[dir][0];
                int j_ = p.j+direction[dir][1];
                if(i_<0 || i_>=n || j_<0 || j_>=m || arr[i_][j_]!=oldcolor) continue;
                q.add(new Pair(i_,j_));            
                arr[i_][j_]=color;
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(image,sr,sc,color);
        return image;
    }
}