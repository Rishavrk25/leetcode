class Solution {
    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
    void helper(String s,int idx,List<String> list,List<List<String>> ans){
        int n=s.length();
        if(idx==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<n;i++){
            String substr = s.substring(idx,i+1);
            if(!isPalindrome(substr)) continue;
            list.add(substr);
            helper(s,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s,0,list,ans);
        return ans;
    }
}