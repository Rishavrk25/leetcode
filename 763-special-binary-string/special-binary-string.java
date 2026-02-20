class Solution {
    String helper(String s){
        List<String> list = new ArrayList<>();
        int sum=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            sum += (ch=='1')?1:-1;
            if(sum==0){
                String sub = s.substring(start+1,i);
                String processed = '1'+helper(sub)+'0';
                list.add(processed);
                start=i+1;
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        String result = "";
        for(String str:list){
            result+=str;
        }
        return result;
    }
    public String makeLargestSpecial(String s) {
        return helper(s);
    }
}