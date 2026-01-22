class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int n=s.length();
        if(n==0) return 0;
        boolean isneg=false;
        int i=0;
        if(s.charAt(i)=='-'){
            isneg=true;
            i++;
        }
        else if(s.charAt(i)=='+'){
            i++;
        }
        long ans=0;
        while(i<n){
            char ch=s.charAt(i);
            if(!Character.isDigit(ch)) break;
            ans = ans*10 + (ch-'0');
            if(!isneg && ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(isneg && -ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        if(isneg) ans=-ans;
        return (int)ans;
    }
}