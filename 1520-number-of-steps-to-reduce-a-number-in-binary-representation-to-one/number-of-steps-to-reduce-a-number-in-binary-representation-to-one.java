class Solution {
    String addOne(String s){
        int n=s.length();
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i=n-1;
        int b=1;
        while(i>=0 || carry==1){
            int a= (i<0)?0:s.charAt(i)-'0';
            int sum = a+b+carry;
            int val = sum%2;
            carry = sum/2;
            b=0;
            ans.append(val);
            i--;
        }
        return ans.reverse().toString();
    }
    String divideByTwo(String s){
        int n=s.length();
        return s.substring(0,n-1);
    }
    public int numSteps(String s) {
        System.out.println(divideByTwo(s));
        int c=0;
        while(!s.equals("1")){
            char ch = s.charAt(s.length()-1);
            if(ch=='1') s = addOne(s);
            else s = divideByTwo(s);
            c++;
        }
        return c;
    }
}