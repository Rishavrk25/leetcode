class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<n){
            char ch = s.charAt(j);
            while(map.containsKey(ch)){
                map.remove(s.charAt(i));
                i++;
            }
            map.put(ch,j);
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}