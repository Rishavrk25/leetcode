class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m) return "";
        Map<Character,Integer> map = new HashMap<>(); // char,freq
        for(int i=0;i<m;i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
        }
        int i=0;
        int j=0;
        int c = m; // required count
        String ans = "";
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) c--;
                map.put(ch,map.get(ch)-1);
            }
            while(c==0){
                if(ans.equals("") || (j-i+1)<ans.length()){
                    ans=s.substring(i,j+1);
                }
                char ch1 = s.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1,map.get(ch1)+1);
                    if(map.get(ch1)>0) c++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}