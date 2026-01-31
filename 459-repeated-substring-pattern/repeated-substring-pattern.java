class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        for(int len=1;len<=n/2;len++){
            String temp="";
            int i=0;
            boolean flag= true;
            while(i<n){
                String sub = "";
                if(i+len<=n) sub=s.substring(i,i+len);
                if(temp.equals("")) temp=sub;
                else{
                    if(!temp.equals(sub)){
                        flag=false;
                        break;
                    }
                }
                i+=len;
            }
            if(flag) return true;
        }
        
        return false;
    }
}