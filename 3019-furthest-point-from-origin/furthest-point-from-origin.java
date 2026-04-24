class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int n=s.length();
        int a=0;
        int b=0;
        int c=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='L') a++;
            else if(ch=='R') b++;
            else c++;
        }
        return Math.abs(a-b) + c;
    }
}