class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m) return "";
        Map<Character,Integer> map = new HashMap<>(); // char,freq
        int countReq = m;
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
        }
        int i=0;
        int j=0;
        int start = -1;
        int minLen = n;
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)>=0) countReq--;
            }
            while(countReq==0){
                char ch1=s.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1,map.get(ch1)+1);
                    if(map.get(ch1)>0) countReq++;
                }
                if(j-i+1 <= minLen){
                    minLen=j-i+1;
                    start=i;
                }
                i++;
            }
            j++;
        }
        if(start==-1) return "";
        return s.substring(start,start+minLen);
    }
}