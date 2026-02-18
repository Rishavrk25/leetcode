class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n&1;
        n = n>>1;
        while(n>0){
            int bit = n&1;
            if(bit==lastBit) return false;
            lastBit = bit;
            n=n>>1;
        }
        return true;
        
    }
}