class Solution {
    void helper(int n,String s,List<String> ans){
        if(n==0){
            ans.add(s);
            return;
        }
        if(s.length()==0 || s.charAt(s.length()-1)!='0') helper(n-1,s+'0',ans);
        helper(n-1,s+'1',ans);
    }
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,"",ans);
        return ans;
    }
}