class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
        // if(n==1) return x;
        // double ans = 0;
        // if(n<0) return 1/(x * myPow(x,-n-1));
        // else return x* myPow(x,n-1);
    }
}