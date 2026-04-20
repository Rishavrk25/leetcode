class Solution {
    public double myPow(double x, int m) {
        long n = m;
        if(n<0) n=-n;
        double ans = 1;
        while(n>0){
            if(n%2!=0){
                ans *= x;
                n=n-1;
            }
            else{
                n = n/2;
                x = x*x;
            }
        }
        if(m<0) return 1.0/ans;
        return ans;
    }
}