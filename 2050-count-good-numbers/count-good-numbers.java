class Solution {
    long MOD = 1000000007;
    long power(long a,long b){
        if(b==0) return 1;
        long p = power(a,b/2);
        if(b%2==0) return (p*p)%MOD;
        else return (p*p*a)%MOD;
    }
    public int countGoodNumbers(long n) {
        long e = (n+1)/2; // no. of even idx
        long o = n/2; // no. of odd idx
        long ans = (power(5,e)*power(4,o))%MOD;
        return (int)ans;
    }
}