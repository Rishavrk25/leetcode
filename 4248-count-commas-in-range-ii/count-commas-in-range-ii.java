class Solution {
    public long countCommas(long n) {
        long ans=0;
        long base = (long)Math.pow(10,3);
        if(n>=base) ans += (n-base+1);
        base = (long)Math.pow(10,6);
        if(n>=base) ans+= (n-base+1);
        base = (long)Math.pow(10,9);
        if(n>=base) ans+= (n-base+1);
        base = (long)Math.pow(10,12);
        if(n>=base) ans+= (n-base+1);
        base = (long)Math.pow(10,15);
        if(n>=base) ans+= (n-base+1);
        return ans;
    }
}