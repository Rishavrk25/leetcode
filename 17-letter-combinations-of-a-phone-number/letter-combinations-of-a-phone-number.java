class Solution {
    void helper(String digits,String map[],int idx,String temp,List<String> ans){
        if(idx==digits.length()){
            ans.add(temp);
            return;
        }
        String letters = map[digits.charAt(idx)-'0'];
        for(int i=0;i<letters.length();i++){
            char ch = letters.charAt(i);
            helper(digits,map,idx+1,temp+ch,ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,map,0,"",ans);
        return ans;
    }
}