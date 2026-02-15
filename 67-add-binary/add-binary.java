class Solution {
    public String addBinary(String a, String b) {
        int n=a.length();
        int m=b.length();
        int i=n-1;
        int j=m-1;
        int carry=0;
        String ans = "";
        while(i>=0 || j>=0 || carry==1){
            int ch1 = (i<0) ? 0 : a.charAt(i)-'0';
            int ch2 = (j<0) ? 0 : b.charAt(j)-'0';
            int sum=ch1+ch2+carry;
            carry--;
            int val = sum%2;
            carry = sum/2;
            ans+=val;
            i--;
            j--;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}