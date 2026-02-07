class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        Stack<Character> st = new Stack<>();
        int c=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek()=='b' && ch=='a'){
                st.pop();
                c++;
            }
            else st.push(ch);
        }
        return c;
    }
}