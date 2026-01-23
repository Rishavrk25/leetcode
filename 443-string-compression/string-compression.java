class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int j=0;
        String s="";
        while(j<n){
            if(chars[i]!=chars[j]){
                s+=chars[i];
                int len = j-i;
                if(len>1) s+=len;
                i=j;
            }
            else j++;
        }
        s+=chars[i];
        int len = j-i;
        if(len>1) s+=len;
        for(int k=0;k<s.length();k++){
            chars[k]=s.charAt(k);
        }
        return s.length();
    }
}