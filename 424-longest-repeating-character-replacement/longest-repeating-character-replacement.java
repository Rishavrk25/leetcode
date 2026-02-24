class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int c=0;
        int maxfreq=0;
        int ans=0;
        Map<Character,Integer> map = new HashMap<>(); // ele,freq
        while(j<n){
            char ch =s.charAt(j);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
            maxfreq =  Math.max(maxfreq,map.get(ch));
            while((j-i+1)-maxfreq>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}