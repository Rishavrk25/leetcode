class Solution {
    int countSetBits(int n){
        int c=0;
        while(n>0){
            if((n&1)==1) c++;
            n=n>>1;
        }
        return c;
    }
    boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            if(isPrime(countSetBits(i))) ans++;
        }
        return ans;
    }
}