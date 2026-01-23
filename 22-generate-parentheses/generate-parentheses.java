class Solution {
    void helper(int n,String s, List<String> ans,int open,int close){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(open<n) helper(n,s+'(',ans,open+1,close);
        if(open>close) helper(n,s+')',ans,open,close+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,"",ans,0,0);
        return ans;
    }
}