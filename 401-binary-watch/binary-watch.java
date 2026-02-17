class Solution {
    int countSetBits(int n){
        int c=0;
        while(n>0){
            if((n&1)==1) c++;
            n=n>>1;
        }
        return c;
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<=11;i++){
            for(int j=0;j<=59;j++){
                int req = countSetBits(i) + countSetBits(j);
                if(req==turnedOn){
                    String s = i+":";
                    if(j<=9) s+="0";
                    s+=j;
                    ans.add(s);
                }
            }
        }
        return ans;
    }
}