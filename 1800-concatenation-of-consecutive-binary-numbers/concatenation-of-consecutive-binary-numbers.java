class Solution {
    int mod = (int)1e9 + 7;
    // StringBuilder intToBinary(int n){
    //     StringBuilder sb = new StringBuilder();
    //     while(n>0){
    //         int rem = n%2;
    //         sb.append(rem);
    //         n=n/2;
    //     }
    //     return sb.reverse();
    // }
    // long binaryToInt(StringBuilder s){
    //     int n=s.length();
    //     long ans = 0;
    //     long base = 1;
    //     for(int i=n-1;i>=0;i--){
    //         char ch = s.charAt(i);
    //         ans += (ch-'0')*base;
    //         ans = ans % mod;
    //         base*=2;
    //         base = base % mod;
    //     }
    //     return ans;
    // }
    public int concatenatedBinary(int n) {
        // StringBuilder concat =new StringBuilder();
        // for(int i=1;i<=n;i++){ // O(n * logn)
        //     concat.append(intToBinary(i));
        // }
        // long ans = binaryToInt(concat);
        // return (int)ans ;
        long ans = 1;
        for(int i=2;i<=n;i++){
            int digits = (int)(Math.log(i)/Math.log(2)) +1; 
            ans=ans<<digits;
            ans+=i;
        ans = ans % mod;
        }
        return (int)ans;

    }
}