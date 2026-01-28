class Solution {
    boolean helper(String s,int idx,List<String> wordDict,int dp[]){
        int n=s.length();
        if(idx==n) return true;
        if(dp[idx]!=-1) return dp[idx]==1;
        boolean ans = false;
        for(int i=idx;i<n;i++){
            String substr = s.substring(idx,i+1);
            if(wordDict.contains(substr)){
                if(helper(s,i+1,wordDict,dp)) ans=true;
            } 
        }
        dp[idx]=(ans)?1:0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,wordDict,dp);
    }
}