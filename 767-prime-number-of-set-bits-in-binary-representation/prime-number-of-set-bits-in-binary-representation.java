class Solution {
    int countSetBits(int n){
        int c=0;
        while(n>0){
            if((n&1)==1) c++;
            n=n>>1;
        }
        return c;
    }
    boolean isPrime(int x){
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            if(isPrime(countSetBits(i))) ans++;
        }
        return ans;
    }
}