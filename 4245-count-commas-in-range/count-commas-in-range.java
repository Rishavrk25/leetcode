class Solution {
    public int countCommas(int n) {
        // if(n<1000) return 0;
        // int ans = n - 1000 + 1;
        // return ans;
        int ans=0;
        for(int i=1000;i<=n;i++){
            int d = (int)Math.log10(i) + 1;
            ans += (d-1)/3;
        }
        return ans;
    }
}