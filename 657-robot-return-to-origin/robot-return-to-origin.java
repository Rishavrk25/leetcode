class Solution {
    public boolean judgeCircle(String moves) {
        int u=0;
        int d=0;
        int l=0;
        int r=0;
        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='U') u++;
            else if(ch=='D') d++;
            else if(ch=='L') l++;
            else r++;
        }
        if(r==l && u==d) return true;
        else return false;
    }
}