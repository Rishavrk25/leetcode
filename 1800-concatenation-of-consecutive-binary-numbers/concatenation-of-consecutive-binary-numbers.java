class Solution {
    int mod = (int)1e9 + 7;
    StringBuilder intToBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int rem = n%2;
            sb.append(rem);
            n=n/2;
        }
        return sb.reverse();
    }
    long binaryToInt(StringBuilder s){
        int n=s.length();
        long ans = 0;
        long base = 1;
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            ans += (ch-'0')*base;
            ans = ans % mod;
            base*=2;
            base = base % mod;
        }
        return ans;
    }
    public int concatenatedBinary(int n) {
        StringBuilder binary[] = new StringBuilder[(int)1e5+1];
        for(int i=1;i<=n;i++){
            binary[i] = intToBinary(i);
        }
        StringBuilder concat =new StringBuilder();
        for(int i=1;i<=n;i++){
            concat.append(binary[i]);
        }
        long ans = binaryToInt(concat) ;
        return (int)ans ;

    }
}