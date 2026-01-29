class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int orangesRotting(int[][] arr) {

        Queue<Pair> q = new LinkedList<>();
        int n=arr.length;
        int m=arr[0].length;
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==2) q.add(new Pair(i,j));
                if(arr[i][j]==1) fresh++;
            }
        }
        int direction[][]={{0,1},{0,-1},{1,0},{-1,0}};
        int c=0;
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            c++;
            for(int i=0;i<size;i++){
                Pair p = q.remove();
                for(int dir=0;dir<4;dir++){
                    int i_ = p.i + direction[dir][0];
                    int j_ = p.j + direction[dir][1];
                    if(i_<0 || i_>=n || j_<0 || j_>=m || arr[i_][j_]!=1) continue;
                    arr[i_][j_]=2;
                    fresh--;
                    q.add(new Pair(i_,j_));
                }
            }
        }
        return (fresh==0)?c:-1;
        
    }
}