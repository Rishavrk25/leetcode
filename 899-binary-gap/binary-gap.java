class Solution {
    public int binaryGap(int n) {
        int max=0;
        int c=0;
        while((n&1)==0) n=n>>1;
        n=n>>1;
        while(n>0){
            if((n&1)==1) c=0;
            else c++;
            max=Math.max(max,c+1);
            n=n>>1;
        }
        return max;
    }
}