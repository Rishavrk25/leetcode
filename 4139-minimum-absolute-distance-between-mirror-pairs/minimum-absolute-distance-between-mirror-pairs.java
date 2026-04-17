class Solution {
    String reverse(String s){
        StringBuilder rev = new StringBuilder();
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)=='0') i--;
        while(i>=0){
            rev.append(s.charAt(i));
            i--;
        }
        return rev.toString();
    }
    public int minMirrorPairDistance(int[] arr) {
        int n=arr.length;
        HashMap<String,Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            String s = "" + arr[i];
            String rev = reverse(s);
            if(map.containsKey(s)) ans = Math.min(ans,i-map.get(s));
            map.put(rev,i);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}