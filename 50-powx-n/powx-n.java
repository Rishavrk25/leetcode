class Solution {
    double helper(double x,int n){
        if(n==0) return 1;
        double ans = helper(x,n/2);
        if(n%2==0) return ans*ans;
        else return ans*ans*x;
    }
    
    public double myPow(double x, int n) {
        // double N = n;
        if(n<0){
            x=1.0/x;
            n=-n;
        }
        return helper(x,n);
    }
}