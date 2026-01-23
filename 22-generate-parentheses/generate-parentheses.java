class Solution {
    void helper(int n,String s, List<String> ans,int c,int i){
        if(i==2*n){
            if(c==0) ans.add(s);
            return;
        }
        if(c<0) return;
        helper(n,s+'(',ans,c+1,i+1);
        helper(n,s+')',ans,c-1,i+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,"",ans,0,0);
        return ans;
    }
}