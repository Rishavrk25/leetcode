class Solution {
    boolean check(int arr[][],int m){
        for(int p[]:arr){
            int actual = p[0];
            int min = p[1];
            if(min>m) return false;
            m = m-actual;
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->{
            int diff1 = a[1]-a[0];
            int diff2 = b[1]-b[0];
            return Integer.compare(diff2,diff1);
        });
        int l=0;
        int h=(int)10e9;
        while(l<h){
            int m=(l+h)/2;
            if(check(tasks,m)) h=m;
            else l=m+1;
        }
        return h;
    }
}