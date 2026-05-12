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

        int s1=0;
        int s2=0;
        for(int p[] : tasks){
            // System.out.println(p[0]+" "+p[1]);
            s1+=p[0];
            s2+=p[1];
        }
        int l=s1;
        int h=s2;
        while(l<h){
            int m=(l+h)/2;
            if(check(tasks,m)) h=m;
            else l=m+1;
        }
        return h;
    }
}