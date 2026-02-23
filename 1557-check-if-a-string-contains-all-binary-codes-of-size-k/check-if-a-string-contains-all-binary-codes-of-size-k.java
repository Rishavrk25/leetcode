class Solution {
    int binaryToDecimal(String s){
        int n=s.length();
        int ans=0;
        int base = 1;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            ans+= base * (ch-'0');
            base*=2;
        }
        return ans;
    }
    public boolean hasAllCodes(String s, int k) {
        boolean arr[] = new boolean[(int)Math.pow(2,k)];
        for(int i=0;i<s.length()-k+1;i++){
            String sub = s.substring(i,i+k);
            int val = binaryToDecimal(sub);
            arr[val]=true;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==false) return false;
        }
        return true;
    }
}