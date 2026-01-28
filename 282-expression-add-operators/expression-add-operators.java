class Solution {
    long eval(String s){
        Stack<Long> st = new Stack<>();
        long val = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                val = val*10 + (ch-'0');
            }
            if(!Character.isDigit(ch) || i==s.length()-1){
                if(sign == '+') st.push(val);
                else if(sign == '-') st.push(-val);
                else if(sign=='*') st.push(st.pop()*val);
                val=0;
                sign=ch;
            }
        }
        long ans=0;
        while(!st.isEmpty()) ans+=st.pop();
        return ans;
    }
    void helper(String num,int target,int idx,String s,List<String> ans){
        int n=num.length();
        if(idx==n){
            if(eval(s)==(long)target) ans.add(s);
            return;
        }
        
        for(int i=idx;i<n;i++){
            // leading zero check
            if(i != idx && num.charAt(idx) == '0') break;

            String part = num.substring(idx,i+1);
            if(idx==0){
                helper(num,target,i+1,s+part,ans);
            }
            else{
                helper(num,target,i+1,s+'+'+part,ans);
                helper(num,target,i+1,s+'-'+part,ans);
                helper(num,target,i+1,s+'*'+part,ans);
            }
            
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(num,target,0,"",ans);
        return ans;
    }
}